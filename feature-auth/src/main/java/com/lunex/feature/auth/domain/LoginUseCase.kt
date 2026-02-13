package com.lunex.feature.auth.domain

import com.lunex.core.common.Resource
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    
    suspend operator fun invoke(email: String, password: String): Resource<Any> {
        // Input validation
        if (email.isBlank()) {
            return Resource.Error("Email cannot be empty")
        }
        
        if (!isValidEmail(email)) {
            return Resource.Error("Invalid email format")
        }
        
        if (password.isBlank()) {
            return Resource.Error("Password cannot be empty")
        }
        
        if (password.length < 6) {
            return Resource.Error("Password must be at least 6 characters")
        }
        
        return authRepository.login(email, password)
    }
    
    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
