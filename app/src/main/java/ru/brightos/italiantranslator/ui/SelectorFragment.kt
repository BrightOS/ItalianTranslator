package ru.brightos.italiantranslator.ui

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_selector.*
import ru.brightos.italiantranslator.App
import ru.brightos.italiantranslator.R
import ru.brightos.italiantranslator.di.Types

class SelectorFragment : Fragment(R.layout.fragment_selector) {

    val args: SelectorFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.application as App).preferenceRepository.selectedType = args.type

        theme?.text = when (args.type) {
            Types.HOME -> "Дом"
            Types.ANIMALS -> "Животные"
            Types.KITCHEN -> "Кухня / Еда"
            Types.EMOTIONS -> "Эмоции"
            else -> null
        }

        learn?.setOnClickListener {
            findNavController().navigate(SelectorFragmentDirections.actionSelectorFragmentToWordLearnFragment())
        }

        check?.setOnClickListener {
            findNavController().navigate(SelectorFragmentDirections.actionSelectorFragmentToWordCheckFragment())
        }

        back?.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}