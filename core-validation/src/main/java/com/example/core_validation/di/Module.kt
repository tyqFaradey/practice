package com.example.core_validation.di

import com.example.core_validation.rules.BlankValidator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

import com.example.core_validation.rules.EmailValidator
import com.example.core_validation.rules.PasswordValidator
import com.example.core_validation.rules.RequiredValidator
import com.example.core_validation.rules.LoginValidator
import java.util.Date

@Module
@InstallIn(SingletonComponent::class)
object ValidationModule {

    @Provides @Singleton
    fun provideBlankValidator(): BlankValidator = BlankValidator()

    @Provides @Singleton
    fun provideDateValidator(): RequiredValidator<Date> = RequiredValidator()

    @Provides @Singleton
    fun provideEmailValidator(): EmailValidator = EmailValidator(
        blankValidator = BlankValidator()
    )

    @Provides @Singleton
    fun providePasswordValidator(): PasswordValidator = PasswordValidator(
        blankValidator = BlankValidator()
    )

    @Provides @Singleton
    fun provideLoginValidator(): LoginValidator = LoginValidator(
        blankValidator = BlankValidator()
    )
}