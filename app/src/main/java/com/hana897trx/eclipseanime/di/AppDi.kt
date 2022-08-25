package com.hana897trx.eclipseanime.di

import android.content.Context
import androidx.room.Room
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.hana897trx.eclipseanime.data.local.config.RoomConfig
import com.hana897trx.eclipseanime.utils.RoomDataBase.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

   @Provides
   fun provideRoomDB(@ApplicationContext context: Context) =
      Room
         .databaseBuilder(
            context,
            RoomConfig::class.java,
            DATABASE_NAME
         ).build()
}