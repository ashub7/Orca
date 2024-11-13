package com.orca.domain.usecases.game

import com.orca.domain.repository.GameRemoteRepository
import kotlinx.coroutines.ensureActive
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class GetHomeScreenDataUseCase @Inject constructor(
    private val repository: GameRemoteRepository,
)  {
    suspend fun invoke(param: GetHomeScreenDataUseCase.Params): Result<List<String>> {
        return runCatching {
            //repository.getListOfGames(param.page)
            listOf("")
        }.onFailure {
            coroutineContext.ensureActive()
        }
    }

    data class Params(val page: Int)
}