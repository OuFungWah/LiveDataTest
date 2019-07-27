package com.oufenghua.livedatatest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class User : ViewModel(){

    var userName: MutableLiveData<String>? = MutableLiveData()

}