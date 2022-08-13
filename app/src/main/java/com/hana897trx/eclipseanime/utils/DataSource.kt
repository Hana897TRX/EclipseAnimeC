package com.hana897trx.eclipseanime.utils

import com.hana897trx.eclipseanime.utils.DefaultValues.EMPTY

sealed class DataSource <out T: Any?> {
   object Loading: DataSource<Nothing>()
   data class Error(val message: String = EMPTY, val errorCode: ErrorCodes) : DataSource<Nothing>()
   data class Success<out T: Any?>(val data: T) : DataSource<T>()
}