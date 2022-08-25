package com.hana897trx.eclipseanime.utils

import androidx.compose.runtime.State

suspend fun <T>DataSource<T>.mapResponse(
    successState: suspend (response: DataSource.Success<T>) -> Unit,
    loadingState: suspend (loading: DataSource.Loading) -> Unit,
    errorState: suspend (error: DataSource.Error) -> Unit
)  {
    when(this) {
        is DataSource.Loading -> loadingState(this)
        is DataSource.Success<T> -> successState(this)
        is DataSource.Error -> errorState(this)
    }
}