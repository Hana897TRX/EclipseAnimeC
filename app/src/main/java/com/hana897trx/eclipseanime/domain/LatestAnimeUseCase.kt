package com.hana897trx.eclipseanime.domain

import com.hana897trx.eclipseanime.utils.NetworkSource
import com.hana897trx.eclipseanime.data.remote.models.LatestM
import com.hana897trx.eclipseanime.data.repository.LatestRepository
import com.hana897trx.eclipseanime.di.IOContext
import com.hana897trx.eclipseanime.utils.DataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LatestAnimeUseCase @Inject constructor(
   private val latestRepository: LatestRepository,
   @IOContext private val contextIO: CoroutineDispatcher
) {
   operator fun invoke(networkSource: NetworkSource = NetworkSource.REMOTE) = flow<DataSource<List<LatestM>>> {
      emit(DataSource.Loading)
      try {
         emit(DataSource.Success(latestRepository.getLatest(networkSource)))
      } catch (e: Exception) {
         emit(DataSource.Error(message = e.message.orEmpty(), code = e.hashCode()))
      }
   }.flowOn(contextIO)
}