package ru.brightos.italiantranslator.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_word_learn.*
import ru.brightos.italiantranslator.App
import ru.brightos.italiantranslator.R
import ru.brightos.italiantranslator.di.PreferenceRepository
import ru.brightos.italiantranslator.di.Word

class WordLearnFragment : Fragment(R.layout.fragment_word_learn) {
    private lateinit var preferenceRepository: PreferenceRepository
    private lateinit var list: ArrayList<Word>
    private val finalList = arrayListOf<Word>()
    private var currentNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferenceRepository = (activity?.application as App).preferenceRepository
        list = (activity?.application as App).list
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back.setOnClickListener {
            if (currentNumber == 0)
                findNavController().popBackStack()
            else
                showAtNumber(--currentNumber)
        }

        next.setOnClickListener {
            if (currentNumber < finalList.size - 1)
                showAtNumber(++currentNumber)
            else
                findNavController().popBackStack()
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
            translation?.text = russian

            Glide.with(this@WordLearnFragment)
                .load(imageUrl)
                .into(image)
        }
    }
}