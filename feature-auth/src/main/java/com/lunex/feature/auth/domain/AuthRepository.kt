package com.lunex.feature.auth.domain

import com.lunex.core.common.Resource

interface AuthRepository {
    
    suspend fun login(email: String, password: String): Resource<Any>
    
    suspend fun register(name: String, email: String, password: String): Resource<Any>
    
    suspend fun logout(): Resource<Unit>
    
    fun isLoggedIn(): Boolean
    
    fun getAuthToken(): String?
}
