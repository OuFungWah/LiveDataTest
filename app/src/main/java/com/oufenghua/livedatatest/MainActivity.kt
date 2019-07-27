package com.oufenghua.livedatatest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    private lateinit var user: User
    private var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initView()
        initObserver()

    }

    private fun initData() {
        user = ViewModelProviders.of(this).get(User::class.java)
        user.userName?.value = "你好"
    }

    private fun initView() {

    }

    private fun initObserver() {
        user.userName?.observe(this, Observer {
            text_activity.text = it
        })
        add_btn.setOnClickListener {
            addFragment()
        }
        remove_btn.setOnClickListener {
            removeFragment()
        }
        input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                user.userName?.postValue(p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })
    }

    private fun addFragment(): Fragment{
        return fragment?:MainFragment().apply {
            supportFragmentManager.beginTransaction().add(R.id.container,this,"main").commit()
            fragment = this
        }
    }

    private fun removeFragment(){
        fragment?.also {
            supportFragmentManager.beginTransaction().remove(it).commit()
            fragment = null
        }
    }
}
