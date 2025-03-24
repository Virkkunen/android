package net.vrkknn.gomuks

import android.net.Uri

private val matrixToFragmentRegex = Regex("^/([@#!][^/]+)(?:/(\\$[^/]+))?\$")

fun matrixToURLToMatrixURI(mxto: Uri): Uri? {
    val fragment = mxto.encodedFragment ?: return null
    val (entity, eventID) = matrixToFragmentRegex.matchEntire(fragment)?.destructured ?: return null
    val entityType = when (entity.getOrNull(0)) {
        '@' -> "u"
        '#' -> "r"
        '!' -> "roomid"
        else -> return null
    }
    var path = "$entityType/${Uri.encode(entity.substring(1))}"
    if (eventID.isNotEmpty()) {
        path += "/e/${Uri.encode(eventID.substring(1))}"
    }
    return Uri.Builder().scheme("matrix").encodedOpaquePart(path).build()
}
