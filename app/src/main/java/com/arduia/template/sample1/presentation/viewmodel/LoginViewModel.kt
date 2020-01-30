package com.arduia.template.sample1.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arduia.template.sample1.framework.AppConfiguration
import com.arduia.template.sample1.presentation.LoginState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private var navigateToCustom  = {}
    private val _loginState = MutableLiveData<LoginState>()
    private val _loginUsernameError = MutableLiveData<String>()
    private val _loginPasswordError = MutableLiveData<String>()



    val loginState:LiveData<LoginState> = _loginState
    val usernameError:LiveData<String> = _loginUsernameError
    val passwordError:LiveData<String> = _loginPasswordError

    fun login(username:String,password:String){
        viewModelScope.launch {
            if(username.isBlank()){
                _loginUsernameError.value = "Username is empty!"
                return@launch
            }
            if(password.isBlank()){
                _loginPasswordError.value = "Password is empty!"
                return@launch
            }
            _loginState.value = LoginState.LOGGING
            delay(2000)
            val validUsername = isValidUsername(username)
            val validPassword = isValidPassword(password)

            if(validPassword && validUsername){
                navigateToCustom()
            }else{
                if(validUsername.not()){
                    _loginUsernameError.value = "Invalid Username"
                }

                if(validPassword.not() && validUsername){
                    _loginPasswordError.value = "Password Wrong!"
                }
            }
            _loginState.value = LoginState.IDLE

        }
    }

    fun usernameEdit(){
        _loginUsernameError.value = ""
    }

    fun passwordEdit(){
        _loginPasswordError.value = ""
    }
    fun customPageNavigator(navigator:()->Unit){
        this.navigateToCustom = navigator
    }

    private fun isValidUsername(username:String):Boolean{
        return AppConfiguration.username == username
    }

    private fun isValidPassword(password: String):Boolean{
        return AppConfiguration.password == password
    }

    init {
        _loginState.value = LoginState.IDLE
    }
}
