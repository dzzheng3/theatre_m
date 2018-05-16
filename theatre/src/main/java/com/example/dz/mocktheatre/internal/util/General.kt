package com.example.dz.mocktheatre.internal.util

fun <T> lazyThreadSaftyNone(initializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)