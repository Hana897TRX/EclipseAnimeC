package com.hana897trx.eclipseanime.domain

import com.hana897trx.eclipseanime.utils.NetworkSource
import com.hana897trx.eclipseanime.data.remote.models.LatestM
import com.hana897trx.eclipseanime.data.repository.LatestRepository
import com.hana897trx.eclipseanime.di.IOContext
import com.hana897trx.eclipseanime.utils.DataSource
import com.hana897trx.eclipseanime.utils.ErrorCodes
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.last
import javax.inject.Inject

class LatestAnimeUseCase @Inject constructor(
   private val latestRepository: LatestRepository,
   @IOContext private val contextIO: CoroutineDispatcher
) {
   operator fun invoke(networkSource: NetworkSource = NetworkSource.REMOTE) = flow {
      emit(DataSource.Loading)
      try {
         emit(latestRepository.getLatest(networkSource).last())
      } catch (e: Exception) {
         emit(DataSource.Error(message = e.message.orEmpty(), errorCode = ErrorCodes.NONE_ERROR))
      }
   }.flowOn(contextIO)
}