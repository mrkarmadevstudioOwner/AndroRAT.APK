package com.lunex.feature.auth.data

import com.lunex.core.network.ApiService
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {
    
    suspend fun login(email: String, password: String): retrofit2.Response<Any> {
        val credentials = mapOf(
            "email" to email,
            "password" to password
        )
        return apiService.login(credentials)
    }
    
    suspend fun register(name: String, email: String, password: String): retrofit2.Response<Any> {
        val userDetails = mapOf(
            "name" to name,
            "email" to email,
            "password" to password
        )
        return apiService.register(userDetails)
    }
}
