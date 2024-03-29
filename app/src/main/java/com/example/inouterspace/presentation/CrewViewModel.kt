package com.example.inouterspace.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inouterspace.domain.repository.CrewRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CrewViewModel(
    private val crewRepository: CrewRepository,
) : ViewModel() {
    private val _crew = MutableStateFlow<List<CrewMemberUiModel>>(emptyList())
    val crew : StateFlow<List<CrewMemberUiModel>> = _crew.asStateFlow()

    init {
        loadCrew()
    }

    private fun loadCrew() {
        viewModelScope.launch {
            _crew.update { crewRepository.getCrew().map { it.toUi() } }
        }
    }
}