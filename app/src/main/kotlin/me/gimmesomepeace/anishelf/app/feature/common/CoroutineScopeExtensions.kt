package me.gimmesomepeace.anishelf.app.feature.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

val defaultExceptionHandler =
    CoroutineExceptionHandler { _, error ->
        Timber.e(error, "Got exception: $error")
    }

fun CoroutineScope.launchSafe(
    context: CoroutineContext = EmptyCoroutineContext,
    onError: suspend (Throwable) -> Unit = {},
    onFinally: suspend () -> Unit = {},
    block: suspend CoroutineScope.() -> Unit,
): Job = launch(context) {
    try {
        block()
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        onError(e)
    } finally {
        onFinally()
    }
}

fun ViewModel.launch(
    context: CoroutineContext = EmptyCoroutineContext,
    onError: suspend (Throwable) -> Unit = {},
    onFinally: suspend () -> Unit = {},
    block: suspend CoroutineScope.() -> Unit,
): Job = viewModelScope.launchSafe(
    context = context + defaultExceptionHandler,
    onError = onError,
    onFinally = onFinally,
    block = block,
)
