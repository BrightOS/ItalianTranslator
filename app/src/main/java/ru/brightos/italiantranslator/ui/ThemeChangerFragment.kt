package ru.brightos.italiantranslator.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_theme_changer.*
import ru.brightos.italiantranslator.R
import ru.brightos.italiantranslator.di.Types

class ThemeChangerFragment : Fragment(R.layout.fragment_theme_changer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        home.setOnClickListener {
            findNavController().navigate(
                ThemeChangerFragmentDirections.actionThemeChangerFragmentToSelectorFragment(
                    Types.HOME
                )
            )
        }

        animals.setOnClickListener {
            findNavController().navigate(
                ThemeChangerFragmentDirections.actionThemeChangerFragmentToSelectorFragment(
                    Types.ANIMALS
                )
            )
        }

        kitchen.setOnClickListener {
            findNavController().navigate(
                ThemeChangerFragmentDirections.actionThemeChangerFragmentToSelectorFragment(
                    Types.KITCHEN
                )
            )
        }

        emotions.setOnClickListener {
            findNavController().navigate(
                ThemeChangerFragmentDirections.actionThemeChangerFragmentToSelectorFragment(
                    Types.EMOTIONS
                )
            )
        }
    }
}