package com.example.starwarsstarships.domain.usecase

import com.example.starwarsstarships.common.Resource
import com.example.starwarsstarships.data.remote.Constants.HTTP_ERROR
import com.example.starwarsstarships.data.remote.Constants.NO_INTERNET_ERROR
import com.example.starwarsstarships.data.remote.Constants.UNKNOWN_ERROR
import com.example.starwarsstarships.domain.model.Starship
import com.example.starwarsstarships.domain.repository.StarshipsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.internal.immutableListOf
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetStarshipsUsecase @Inject constructor (private val repository: StarshipsRepository) {

    operator fun invoke(): Flow<Resource<List<Starship>>> = flow {
        try {
            emit(Resource.Loading())
            val starshipDTOs = repository.getStarships().starshipsDT0s
            var starships: MutableList<Starship> = mutableListOf<Starship>()
            starshipDTOs.forEach { it ->
                starships.add(it.toStarship())
            }
            emit(Resource.Success<List<Starship>>(starships))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Starship>>(message = e.localizedMessage+HTTP_ERROR))
        } catch (e: IOException) {
            emit(Resource.Error<List<Starship>>(message = e.localizedMessage+NO_INTERNET_ERROR))
        } catch (e: Exception) {
            emit(Resource.Error<List<Starship>>(message = e.localizedMessage+UNKNOWN_ERROR))
        }
    }
}