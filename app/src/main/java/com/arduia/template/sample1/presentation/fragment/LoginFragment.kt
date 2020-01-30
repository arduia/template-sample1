package com.arduia.template.sample1.presentation.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

import com.arduia.template.sample1.R
import com.arduia.template.sample1.presentation.LoginState
import com.arduia.template.sample1.presentation.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment() {

    private  val  viewModel by viewModels<LoginViewModel>()
    private lateinit var navOption:NavOptions
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupView()
        navOption = NavOptions.Builder().setPopUpTo(R.id.loginFragment,true).build()
        setupViewModel()
    }

    private fun setupView(){
        main_login_btn.setOnClickListener {
            val username = main_username_edt.text.toString()
            val password = main_password_edt.text.toString()
            viewModel.login(username,password)
        }

        main_username_edt.addTextChangedListener (object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.usernameEdit()
            }
        })

        main_password_edt.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.passwordEdit()
            }
        })

    }

    private fun setupViewModel(){

        viewModel.customPageNavigator {
           findNavController().navigate(R.id.customFragment,null,navOption)
        }

        viewModel.passwordError.observe(viewLifecycleOwner, Observer {
            if(it.isNotBlank()){

                main_password_layout.error  = it
            }else{
                main_urname_layout.error
            }
        })

        viewModel.usernameError.observe(viewLifecycleOwner, Observer {
            main_urname_layout.error = it
        })

        viewModel.loginState.observe(viewLifecycleOwner, Observer {
            when(it){

                LoginState.IDLE -> {
                    //View Logic
                    main_username_edt.isEnabled = true
                    main_password_edt.isEnabled = true
                    main_login_btn.visibility= View.VISIBLE
                    main_progress_bar.visibility = View.INVISIBLE
                }

                LoginState.LOGGING ->{
                    //View Logic
                    main_username_edt.isEnabled = false
                    main_password_edt.isEnabled = false
                    main_login_btn.visibility= View.INVISIBLE
                    main_progress_bar.visibility = View.VISIBLE

                }

                else -> {}
            }
        })
    }


}
