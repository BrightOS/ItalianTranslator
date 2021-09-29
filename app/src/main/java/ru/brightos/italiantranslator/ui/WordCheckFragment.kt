package ru.brightos.italiantranslator.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_word_check.*
import kotlinx.android.synthetic.main.fragment_word_check.count
import kotlinx.android.synthetic.main.fragment_word_check.image
import kotlinx.android.synthetic.main.fragment_word_check.max
import kotlinx.android.synthetic.main.fragment_word_check.word
import ru.brightos.italiantranslator.App
import ru.brightos.italiantranslator.R
import ru.brightos.italiantranslator.di.PreferenceRepository
import ru.brightos.italiantranslator.di.Word

class WordCheckFragment : Fragment(R.layout.fragment_word_check) {
    private lateinit var preferenceRepository: PreferenceRepository
    private lateinit var list: ArrayList<Word>
    private val finalList = arrayListOf<Word>()
    private var currentNumber = 0
    private var rightCount = 0
    private var rightNumber = 0
    // 0 - первая кнопка
    // 1 - вторая кнопка

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferenceRepository = (activity?.application as App).preferenceRepository
        list = (activity?.application as App).list
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        first?.setOnClickListener {
            if (rightNumber == 0)
                score?.text = "${++rightCount}"

            if (currentNumber >= finalList.size - 1) {
                findNavController().popBackStack()
                Toast.makeText(context, "Вы набрали $rightCount очко(а/ов)!", Toast.LENGTH_LONG)
                    .show()
            } else
                showAtNumber(++currentNumber)
        }

        second?.setOnClickListener {
            if (rightNumber == 1)
                score?.text = "${++rightCount}"

            if (currentNumber >= finalList.size - 1) {
                findNavController().popBackStack()
                Toast.makeText(context, "Вы набрали $rightCount очко(а/ов)!", Toast.LENGTH_LONG)
                    .show()
            } else
                showAtNumber(++currentNumber)
        }

        list.forEach {
            if (it.type == preferenceRepository.selectedType)
                finalList.add(it)
        }

        max?.text = "${finalList.size}"

        showAtNumber(0)
    }

    private fun showAtNumber(pos: Int) {
        count?.text = "${pos + 1}"
        finalList[pos].apply {
            word?.text = italian

            (0..1).random().let {
                if (it == 0) {
                    rightNumber = 0
                    first?.text = russian

                    var temp: Int
                    do {
                        temp = (0 until finalList.size).random()
                    } while (temp == pos)

                    second?.text = finalList[temp].russian
                } else {
                    rightNumber = 1
                    second?.text = russian

                    var temp: Int
                    do {
                        temp = (0 until finalList.size).random()
                    } while (temp == pos)

                    first?.text = finalList[temp].russian
                }
            }

            Glide.with(this@WordCheckFragment)
                .load(imageUrl)
                .into(image)
        }
    }
}