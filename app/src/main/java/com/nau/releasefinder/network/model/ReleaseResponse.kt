package com.nau.releasefinder.network.model

import com.nau.releasefinder.data.database.model.Release

data class ReleaseResponse(
    val results: List<Release>
)