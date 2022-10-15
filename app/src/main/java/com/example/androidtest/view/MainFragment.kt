package com.example.androidtest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import com.example.androidtest.databinding.MainFragmentBinding
import com.example.androidtest.viewmodel.MainViewModel

/**
 * Main fragment. Fragment with Images Recycler Grid.
 *
 * @author Nicholas Almeida
 */
@AndroidEntryPoint
class MainFragment: Fragment() {
    private lateinit var binding: MainFragmentBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = ImagesRecyclerAdapter()
        binding.imageGrid.layoutManager = GridLayoutManager(requireContext(), 4)
        binding.imageGrid.adapter = adapter

        viewModel.images.observe (viewLifecycleOwner){
            adapter.submitList(it)
        }

        viewModel.requestImages()
    }
}