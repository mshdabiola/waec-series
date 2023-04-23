package com.mshdabiola.database

import com.mshdabiola.database.dao.ModelDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {

    @Provides
    fun modelDaoProvider(ludoDatabase: SkeletonDatabase): ModelDao {
        return ludoDatabase.getModelDao()
    }
}
