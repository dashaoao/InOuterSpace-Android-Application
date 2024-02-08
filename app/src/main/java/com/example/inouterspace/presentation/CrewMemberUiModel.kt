package com.example.inouterspace.presentation

import com.example.inouterspace.domain.model.CrewMember

data class CrewMemberUiModel(
    val id : String,
    val fullName: String,
    val agency: String,
    val imageUrl: String,
)

fun CrewMember.toUi() = CrewMemberUiModel(
    id = id,
    fullName = fullName,
    agency = agency,
    imageUrl = imageUrl,)