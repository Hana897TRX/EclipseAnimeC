package com.hana897trx.eclipseanime.data.remote.latest

import com.google.firebase.firestore.FirebaseFirestore
import com.hana897trx.eclipseanime.utils.DefaultValues.PAGINATION_VALUE
import com.hana897trx.eclipseanime.data.remote.models.LatestM
import com.hana897trx.eclipseanime.data.remote.models.toMapLatest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LatestRemoteDataSourceImp @Inject constructor(
   private val fbDB : FirebaseFirestore
): LatestRemoteDataSource {
   override suspend fun getLatest(): List<LatestM> {
      val response = fbDB.collection("anime")
            .limit(PAGINATION_VALUE)
            .get()
            .await()

      return if (!response.isEmpty) {
         val docs = response.documents
         if (docs.isNotEmpty()) {
            docs.toMapLatest()
         } else {
            throw Exception("EMPTY")
         }
      } else {
         throw Exception("SOME ERROR")
      }
   }
}