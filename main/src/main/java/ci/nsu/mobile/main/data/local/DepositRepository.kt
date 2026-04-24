package ci.nsu.mobile.main.data.local

import kotlinx.coroutines.flow.Flow

class DepositRepository(private val depositDao: DepositDao) {
    val allCalculations: Flow<List<DepositEntity>> = depositDao.getAll()

    fun insert(calculation: DepositEntity) {
        depositDao.insert(calculation)
    }
}