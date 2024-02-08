package com.example.inouterspace.data.api.model

import com.example.inouterspace.domain.model.CrewMember
import com.google.gson.annotations.SerializedName

class CrewMemberDto(
        @SerializedName("id") val id: String? = null,
        @SerializedName("name") val fullName: String? = null,
        @SerializedName("agency") val agency: String? = null,
        @SerializedName("image") val imageUrl: String? = null,
    )
fun CrewMemberDto.toDomain(): CrewMember? {
    return CrewMember(
        id = id ?: return null,
        fullName = fullName ?: return null,
        agency = agency ?: return null,
        imageUrl = imageUrl ?: return null,
    )
}