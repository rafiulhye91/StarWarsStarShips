package com.example.starwarsstarships.di

import com.example.starwarsstarships.data.remote.ApiServices
import com.example.starwarsstarships.data.remote.RetrofitInstance
import com.example.starwarsstarships.data.repository.StarshipsRepositoryImpl
import com.example.starwarsstarships.domain.repository.StarshipsRepository
import com.example.starwarsstarships.domain.usecase.GetStarshipsUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApiServices():ApiServices{
        return  RetrofitInstance.getApiServices()
    }

    @Singleton
    @Provides
    fun provideRepository(apiServices: ApiServices):StarshipsRepository{
        return StarshipsRepositoryImpl(apiServices)
    }

    @Singleton
    @Provides
    fun providesUseCase(repository: StarshipsRepository): GetStarshipsUsecase {
        return GetStarshipsUsecase(repository)
    }

}