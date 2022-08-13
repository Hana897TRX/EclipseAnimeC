package com.hana897trx.eclipseanime.data.remote.latest

import com.google.firebase.firestore.FirebaseFirestore
import com.hana897trx.eclipseanime.utils.DefaultValues.PAGINATION_VALUE
import com.hana897trx.eclipseanime.data.remote.models.LatestM
import com.hana897trx.eclipseanime.data.remote.models.toMapLatest
import com.hana897trx.eclipseanime.utils.AnimeSchema.SchemaName
import com.hana897trx.eclipseanime.utils.AnimeSchema.UpdatedField
import com.hana897trx.eclipseanime.utils.DataSource
import com.hana897trx.eclipseanime.utils.ErrorCodes
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LatestRemoteDataSourceImp @Inject constructor(
   private val fbDB : FirebaseFirestore
): LatestRemoteDataSource {
   override suspend fun getLatest(): Flow<DataSource<List<LatestM>>> = flow {
      fbDB.collection(SchemaName)
         .orderBy(UpdatedField)
         .limit(PAGINATION_VALUE)
         .get()
         .addOnSuccessListener { response ->
            val docs = response.documents
            if (docs.isNotEmpty()) {
               GlobalScope.launch {
                  emit(
                     DataSource.Success(docs.toMapLatest())
                  )
               }
            } else {
               GlobalScope.launch {
                  emit(
                     DataSource.Error(errorCode = ErrorCodes.EMPTY_RESPONSE)
                  )
               }
            }
         }
         .addOnFailureListener {
            GlobalScope.launch {
               emit(DataSource.Error(message = it.message.orEmpty(), errorCode = ErrorCodes.SERVER_DOWN))
            }
         }
   }
}