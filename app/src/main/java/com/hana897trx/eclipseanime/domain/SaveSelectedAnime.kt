package com.hana897trx.eclipseanime.domain

import com.hana897trx.eclipseanime.data.remote.models.LatestM
import com.hana897trx.eclipseanime.data.remote.models.toLatestMDBSelected
import com.hana897trx.eclipseanime.data.repository.AnimeRepository
import com.hana897trx.eclipseanime.utils.DataSource
import com.hana897trx.eclipseanime.utils.ErrorCodes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SaveSelectedAnime @Inject constructor(
    private val animeRepository: AnimeRepository
){
    operator fun invoke(latestM: LatestM) = flow<DataSource<Long>> {
        emit(DataSource.Loading)
        try {
            val animeOld = animeRepository.getSelectedAnime()
            animeOld?.let {
                animeRepository.saveAnime(it.copy(selected = false))
            }
            emit(
                DataSource.Success(
                    animeRepository.saveAnime(
                        latestM.toLatestMDBSelected()
                    )
                )
            )
        } catch (e: Exception) {
            emit(
                DataSource.Error(
                    message = e.message.orEmpty(),
                    errorCode = ErrorCodes.ERROR_NOT_RELATED
                )
            )
        }
    }.flowOn(Dispatchers.IO)
}