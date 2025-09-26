package com.ashutosh.tajakhabar.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashutosh.tajakhabar.domain.usecase.AppEntryUseCases
import com.ashutosh.tajakhabar.domain.usecase.SaveAppEntryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appEntryUseCase: AppEntryUseCases
) : ViewModel(){
    fun onEvent(onBoardingEvent: OnBoardingEvent){
        when(onBoardingEvent){
            is OnBoardingEvent.saveEntryApp -> {
                saveEntryApp()
            }
        }
    }
    private fun saveEntryApp(){
        viewModelScope.launch {
            appEntryUseCase.saveAppEntry()
        }
    }

}
