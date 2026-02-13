package com.lunex.core.network

import retrofit2.http.*

interface ApiService {
    
    @POST("auth/login")
    suspend fun login(
        @Body credentials: Map<String, String>
    ): retrofit2.Response<Any>
    
    @POST("auth/register")
    suspend fun register(
        @Body userDetails: Map<String, String>
    ): retrofit2.Response<Any>
    
    @GET("user/profile")
    suspend fun getProfile(
        @Header("Authorization") token: String
    ): retrofit2.Response<Any>
    
    @GET("dashboard/data")
    suspend fun getDashboardData(
        @Header("Authorization") token: String
    ): retrofit2.Response<Any>
}
