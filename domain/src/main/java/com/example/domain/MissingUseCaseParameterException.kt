package com.example.domain

class MissingUseCaseParameterException(kClass: Class<Any>) : IllegalArgumentException("Parameters are mandatory for " +
    kClass::class.java.simpleName)