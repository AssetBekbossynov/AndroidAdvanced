package com.example.asset.lab3

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CategoryFragment: Fragment() {

    companion object {

        internal var categoryFragment = CategoryFragment()

        fun newInstance(): CategoryFragment {
            return categoryFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.category_fragment, container, false)
        return view
    }
}