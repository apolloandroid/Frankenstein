package com.example.itunesmvp.domain

data class Settings(
    val language: AppLanguage,
    val theme: AppTheme,
    val authMethod: AuthMethod,
    val version: String
)
