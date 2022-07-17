package com.hana897trx.eclipseanime.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

annotation class IOContext

@Module
@InstallIn(SingletonComponent::class)
object AppDi {

   @Singleton
   @Provides
   fun provideRetrofit() : Retrofit {
      return Retrofit.Builder()
         .baseUrl("")
         .addConverterFactory(GsonConverterFactory.create())
         .build()
   }

   @Singleton
   @Provides
   fun provideFirestore() : FirebaseFirestore = Firebase.firestore

   @Provides
   @IOContext
   fun provideIOContext() : CoroutineDispatcher = Dispatchers.IO
}