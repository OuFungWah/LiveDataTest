package com.oufenghua.livedatatest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class MainFragment : Fragment() {

    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
    }

    private fun initData() {
        user = ViewModelProviders.of(activity!!).get(User::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_main, container, false).also { v ->
            initView()
            initObserver(v)
        }
    }

    private fun initView() {

    }

    private fun initObserver(v: View) {
        user.userName?.observe(this, Observer<String> { t ->
            v.findViewById<TextView>(R.id.text_fragment).text = t
        })
    }

}