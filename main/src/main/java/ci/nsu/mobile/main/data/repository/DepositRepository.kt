package ci.nsu.mobile.main.data.repository

import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

import ci.nsu.mobile.main.data.local.DepositDao
import ci.nsu.mobile.main.data.local.DepositEntity


@Singleton
class DepositRepository @Inject constructor(
    private val dao: DepositDao
) {

    suspend fun save(entity: DepositEntity) {
        dao.insert(entity)
    }

    fun getAll(): Flow<List<DepositEntity>> {
        return dao.getAll()
    }
}