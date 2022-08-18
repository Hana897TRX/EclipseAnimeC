package com.hana897trx.eclipseanime.utils

import android.os.Bundle
import androidx.navigation.NavType
import com.google.gson.Gson
import com.hana897trx.eclipseanime.data.remote.models.LatestM

class AssetParamType : NavType<LatestM>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): LatestM? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): LatestM {
        return Gson().fromJson(value, LatestM::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: LatestM) {
        bundle.putParcelable(key, value)
    }
}