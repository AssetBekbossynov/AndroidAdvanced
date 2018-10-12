package com.example.asset.midterm

import android.support.v4.app.Fragment

class DoneFragment : Fragment(){

    companion object {

        internal var doneFragment = DoneFragment()

        fun newInstance(): DoneFragment {
            return doneFragment
        }
    }
}