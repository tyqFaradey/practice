package com.example.feature_auth.di

import com.example.core_domain.Gender
import com.example.core_domain.schemas.Group
import com.example.core_validation.rules.RequiredSelectionValidator
import com.example.feature_auth.api.AuthApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides @Singleton
    fun provideAuthApi(retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }

    @Provides @Singleton
    fun provideGenderValidator(): RequiredSelectionValidator<Gender> = RequiredSelectionValidator()
    @Provides @Singleton
    fun provideGroupValidator(): RequiredSelectionValidator<Group> = RequiredSelectionValidator()
}