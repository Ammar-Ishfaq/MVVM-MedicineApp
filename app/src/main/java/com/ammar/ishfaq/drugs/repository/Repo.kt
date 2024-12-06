package com.ammar.ishfaq.drugs.repository

import com.ammar.ishfaq.drugs.data.managers.DataManager
import com.ammar.ishfaq.drugs.data.BaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Repo @Inject constructor(dataManager: DataManager) : BaseRepository(dataManager) {
    private val dispatcher = Dispatchers.IO
    suspend fun getList() = withContext(dispatcher) {
        safeApiCall { Result.success(dataManager.getApiHelper().getList()) }
    }
}