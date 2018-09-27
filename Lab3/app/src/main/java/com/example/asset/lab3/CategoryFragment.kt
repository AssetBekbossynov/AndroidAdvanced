package com.example.asset.lab3

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CategoryFragment: Fragment() {

    companion object {
        fun newInstance() : CategoryFragment {
            val fragment = CategoryFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.news_fragment, container, false)
    }
}