package com.hana897trx.eclipseanime.utils

object DefaultValues {
    const val EMPTY = ""
    const val ZERO = 0
    const val PAGINATION_VALUE = 10L
}

enum class NetworkSource {
    REMOTE,
    LOCAL
}

enum class ErrorCodes(error: String) {
    EMPTY_RESPONSE("EMPTY RESPONSE"),
    SERVER_DOWN("SERVER_DOWN"),
    ERROR_NOT_RELATED("not_related"),
    NONE_ERROR("")
}

object AnimeSchema {
    const val SchemaName = "anime"
    const val UpdatedField = "updated"
}

object Screens {
    const val HOME_SCREEN = "home"
    const val DETAILS_SCREEN_ANIME_DATA_ARG = "{anime_data}"
    const val DETAILS_SCREEN = "details"
}

object RoomDataBase {
    const val DATABASE_NAME = "eclipseC"
}