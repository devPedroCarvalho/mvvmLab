package com.teste.mvvmlab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

class Fragment_A: Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels<MainViewModel>()

    private lateinit var counterTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        counterTextView = view.findViewById(R.id.counterTextView)

        val addButton: Button = view.findViewById(R.id.addButton)
        addButton.setOnClickListener { mainViewModel.sumNumbers() }

        val nextButton: Button = view.findViewById(R.id.nextButton)
        nextButton.setOnClickListener { findNavController().navigate(R.id.action_fragment_A_to_fragment_B) }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mainViewModel.counter.observe(viewLifecycleOwner, Observer {
            counterTextView.text = it
        })
    }
}