package com.hana897trx.eclipseanime.utils

sealed class DataSource <out T: Any?> {
   object Loading: DataSource<Nothing>()
   data class Error(val message: String, val code: Int = 0) : DataSource<Nothing>()
   data class Success<out T: Any?>(val data: T) : DataSource<T>()
}