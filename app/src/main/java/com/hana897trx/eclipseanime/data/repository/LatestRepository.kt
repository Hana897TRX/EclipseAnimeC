package com.hana897trx.eclipseanime.data.repository

import com.hana897trx.eclipseanime.utils.NetworkSource
import com.hana897trx.eclipseanime.data.remote.models.LatestM

interface LatestRepository {
   suspend fun getLatest(networkSource: NetworkSource) : List<LatestM>
}