package com.example.inouterspace.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.inouterspace.databinding.FragmentCrewBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class CrewFragment : Fragment() {

    private val viewModel: CrewViewModel by viewModel()
    private val crewAdapter = CrewAdapter()

    private var _binding: FragmentCrewBinding? = null
    private val binding: FragmentCrewBinding
        get() = _binding ?: throw RuntimeException("FragmentCrewBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCrewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCrew.adapter = crewAdapter
        lifecycleScope.launch {
            viewModel.crew.collect {
                crewAdapter.submitList(it)
            }
        }
    }
}