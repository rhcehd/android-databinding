package dev.rhcehd123.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val toastEvent = SingleLiveEvent<String>()

    val liveData: MutableLiveData<String> = MutableLiveData("This string is initialized with LiveData")
    val liveDataInput: MutableLiveData<String> = MutableLiveData("")
    val flow: MutableStateFlow<String> = MutableStateFlow("This string is initialized with StateFlow")
    val flowInput: MutableStateFlow<String> = MutableStateFlow("")

    fun onClickLiveDataSubmitButton() {
        liveData.postValue(liveDataInput.value)
        toastEvent.postValue("submit LiveData")
    }

    fun onClickFlowSubmitButton() {
        viewModelScope.launch {
            flow.emit(flowInput.value)
        }
        toastEvent.postValue("submit Flow")
    }
}