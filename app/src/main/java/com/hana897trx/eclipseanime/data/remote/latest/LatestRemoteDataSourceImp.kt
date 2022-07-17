package com.hana897trx.eclipseanime.data.remote.latest

import com.google.firebase.firestore.FirebaseFirestore
import com.hana897trx.eclipseanime.utils.DefaultValues.PAGINATION_VALUE
import com.hana897trx.eclipseanime.data.remote.models.LatestM
import com.hana897trx.eclipseanime.data.remote.models.toMapLatest
import javax.inject.Inject

class LatestRemoteDataSourceImp @Inject constructor(
   private val fbDB : FirebaseFirestore
): LatestRemoteDataSource {
   override suspend fun getLatest(): List<LatestM> {
      val response = fbDB.collection("anime")
         .orderBy("updated")
         .limit(PAGINATION_VALUE)
         .get()

      return if (response.isSuccessful) {
         val docs = response.result.documents
         if (docs.isNotEmpty()) {
            docs.toMapLatest()
         } else {
            throw Exception(response.exception?.message)
         }
      } else {
         throw Exception(response.exception?.message)
      }
   }
}