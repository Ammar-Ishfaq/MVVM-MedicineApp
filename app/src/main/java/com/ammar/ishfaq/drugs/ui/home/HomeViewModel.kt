package com.ammar.ishfaq.drugs.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ammar.ishfaq.drugs.data.room.DrugDao
import com.ammar.ishfaq.drugs.repository.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: Repo,
    private val drugDao: DrugDao
) : ViewModel() {
    private val _response = MutableStateFlow<HomeScreenUiState>(HomeScreenUiState.Initial)
    val response: StateFlow<HomeScreenUiState> = _response.asStateFlow()

    fun loadData(isPullToRef: Boolean = false) {
        viewModelScope.launch {
            _response.value = HomeScreenUiState.Loading
            val drugsLocalData = drugDao.getAllDrugs()
            if (drugsLocalData != null && isPullToRef.not()) {
                _response.value =
                    HomeScreenUiState.Success(obj = drugsLocalData)
            } else {
                drugDao.clearAllDrugs()
                repo.getList().run {
                    onSuccess {
                        if (it.problems.isEmpty()) {
                            _response.value =
                                HomeScreenUiState.Error(
                                    msg = "Looks like it's empty out there."
                                )
                        } else {
                            drugDao.insert(it)
                            _response.value =
                                HomeScreenUiState.Success(obj = it)
                        }
                    }
                    onFailure {

                        _response.value =
                            HomeScreenUiState.Error(
                                msg = it.message ?: "Something went wrong."
                            )
                    }
                }
            }
        }
    }
}
