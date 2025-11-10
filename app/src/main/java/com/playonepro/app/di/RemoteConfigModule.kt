package com.playonepro.app.di

import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.remoteConfig
import com.playonepro.app.core.remoteconfig.FirebaseRemoteConfigService
import com.playonepro.app.core.remoteconfig.RemoteConfigService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt Dependency Injection module for Remote Config.
 * 
 * This module provides:
 * - FirebaseRemoteConfig instance as a singleton
 * - RemoteConfigService implementation binding
 * 
 * The module is installed in SingletonComponent, making dependencies available
 * application-wide with a single instance throughout the app lifecycle.
 */
@Module
@InstallIn(SingletonComponent::class)
object RemoteConfigModule {

    /**
     * Provides FirebaseRemoteConfig instance.
     * 
     * @return Singleton instance of FirebaseRemoteConfig
     */
    @Provides
    @Singleton
    fun provideFirebaseRemoteConfig(): FirebaseRemoteConfig {
        return Firebase.remoteConfig
    }

    /**
     * Provides RemoteConfigService implementation.
     * 
     * Binds FirebaseRemoteConfigService as the implementation of RemoteConfigService.
     * This allows for easy testing and potential swapping of implementations.
     * 
     * @param remoteConfig FirebaseRemoteConfig instance
     * @return Singleton instance of RemoteConfigService
     */
    @Provides
    @Singleton
    fun provideRemoteConfigService(
        remoteConfig: FirebaseRemoteConfig
    ): RemoteConfigService {
        return FirebaseRemoteConfigService(remoteConfig)
    }
}
