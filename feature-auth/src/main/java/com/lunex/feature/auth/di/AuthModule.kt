package com.lunex.feature.auth.di

import com.lunex.core.network.ApiService
import com.lunex.feature.auth.data.AuthRemoteDataSource
import com.lunex.feature.auth.data.AuthRepositoryImpl
import com.lunex.feature.auth.domain.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    
    @Provides
    @Singleton
    fun provideAuthRemoteDataSource(apiService: ApiService): AuthRemoteDataSource {
        return AuthRemoteDataSource(apiService)
    }
    
    @Provides
    @Singleton
    fun provideAuthRepository(
        context: android.content.Context,
        remoteDataSource: AuthRemoteDataSource
    ): AuthRepository {
        return AuthRepositoryImpl(context, remoteDataSource)
    }
}
