package com.example.multiplanformapp.shared

import kotlin.coroutines.CoroutineContext

expect val ioDispatcher: CoroutineContext

expect val uiDispatcher: CoroutineContext
