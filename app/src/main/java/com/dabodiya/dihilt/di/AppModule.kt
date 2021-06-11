package com.dabodiya.dihilt.di

import android.content.Context
import com.dabodiya.dihilt.app.MyApplication
import com.dabodiya.dihilt.listener.EventListener
import com.dabodiya.dihilt.listener.ResourceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): MyApplication {
        return app as MyApplication
    }

    @Singleton
    @Provides
    fun provideRandomString(): String {
        return "Hello this is DI hilt"
    }

    @Provides
    @Singleton
    fun providesEventListener(resourceProvider: ResourceProvider) :EventListener{
       return EventListener(resourceProvider)
    }

    @Provides
    @Singleton
    fun providesResourceProvider(@ApplicationContext app: Context): ResourceProvider {
        return ResourceProvider(app)
    }
}