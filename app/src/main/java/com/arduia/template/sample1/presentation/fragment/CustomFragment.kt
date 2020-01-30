package com.arduia.template.sample1.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels

import com.arduia.template.sample1.framework.AppConfiguration
import com.arduia.template.sample1.presentation.viewmodel.CustomViewModel

class CustomFragment : Fragment() {

    private val viewModel by viewModels<CustomViewModel> ()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return AppConfiguration.customPage
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}
