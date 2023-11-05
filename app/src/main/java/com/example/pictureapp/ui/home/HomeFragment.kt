package com.example.pictureapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.example.pictureapp.databinding.FragmentHomeBinding
import com.example.pictureapp.domain.model.Photo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val randomPhotosAdapter = RandomPhotosAdapter(
            onLikeClicked = { photo -> likePhoto(photo) },
            onDislikeClicked = { photo -> unLikePhoto(photo) },
        )

        binding.recyclerview.adapter = randomPhotosAdapter.withLoadStateFooter(
            footer = ReposLoadStateAdapter { randomPhotosAdapter.retry() }
        )

        binding.swipeRefresh.setOnRefreshListener {
            randomPhotosAdapter.refresh()
        }

        randomPhotosAdapter.loadStateFlow.onEach { state ->
            binding.swipeRefresh.isRefreshing = state.refresh == LoadState.Loading
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.randomPhotos().onEach { photo ->
            randomPhotosAdapter.submitData(photo)
        }.launchIn(viewLifecycleOwner.lifecycleScope)

    }

    private fun likePhoto(photo: Photo) {
        viewModel.likePhoto(photo)
    }

    private fun unLikePhoto(photo: Photo) {
        viewModel.unLikePhoto(photo)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
