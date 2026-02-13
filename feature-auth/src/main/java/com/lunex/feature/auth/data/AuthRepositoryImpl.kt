package com.lunex.feature.auth.data

import android.content.Context
import android.content.SharedPreferences
import com.lunex.core.common.Constants
import com.lunex.core.common.Resource
import com.lunex.feature.auth.domain.AuthRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val remoteDataSource: AuthRemoteDataSource
) : AuthRepository {
    
    private val sharedPreferences: SharedPreferences = 
        context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE)
    
    override suspend fun login(email: String, password: String): Resource<Any> {
        return try {
            val response = remoteDataSource.login(email, password)
            
            if (response.isSuccessful) {
                val data = response.body()
                // In a real app, you would extract the token from the response
                // and save it to SharedPreferences
                saveAuthToken("dummy_token_for_demo")
                Resource.Success(data ?: "Login successful")
            } else {
                Resource.Error("Login failed: ${response.message()}")
            }
        } catch (e: Exception) {
            Resource.Error("Network error: ${e.localizedMessage}")
        }
    }
    
    override suspend fun register(name: String, email: String, password: String): Resource<Any> {
        return try {
            val response = remoteDataSource.register(name, email, password)
            
            if (response.isSuccessful) {
                Resource.Success(response.body() ?: "Registration successful")
            } else {
                Resource.Error("Registration failed: ${response.message()}")
            }
        } catch (e: Exception) {
            Resource.Error("Network error: ${e.localizedMessage}")
        }
    }
    
    override suspend fun logout(): Resource<Unit> {
        clearAuthToken()
        return Resource.Success(Unit)
    }
    
    override fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(Constants.KEY_IS_LOGGED_IN, false)
    }
    
    override fun getAuthToken(): String? {
        return sharedPreferences.getString(Constants.KEY_AUTH_TOKEN, null)
    }
    
    private fun saveAuthToken(token: String) {
        sharedPreferences.edit().apply {
            putString(Constants.KEY_AUTH_TOKEN, token)
            putBoolean(Constants.KEY_IS_LOGGED_IN, true)
            apply()
        }
    }
    
    private fun clearAuthToken() {
        sharedPreferences.edit().apply {
            remove(Constants.KEY_AUTH_TOKEN)
            putBoolean(Constants.KEY_IS_LOGGED_IN, false)
            apply()
        }
    }
}
