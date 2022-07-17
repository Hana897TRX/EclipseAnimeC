package com.hana897trx.eclipseanime.data.remote.latest

import com.hana897trx.eclipseanime.data.remote.models.LatestM

interface LatestRemoteDataSource{
    suspend fun getLatest() : List<LatestM>
}