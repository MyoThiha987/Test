package com.techgod.mmchel.ui.two.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.techgod.mmchel.R
import com.techgod.mmchel.ui.two.TwoDFragment
import com.techgod.mmchel.ui.two.guess.GuessFragment
import com.techgod.mmchel.ui.two.three.ThreeDFragment
import kotlinx.android.synthetic.main.activity_main.*
import me.ibrahimsn.lib.OnItemSelectedListener

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpBottomBar()
    }

    private fun setUpBottomBar() {
        changeFragment(TwoDFragment())
        bottomNavView.onItemSelectedListener= object : OnItemSelectedListener{
            override fun onItemSelect(pos: Int): Boolean {
                when(pos){
                    0->changeFragment(TwoDFragment())
                    1->changeFragment((ThreeDFragment()))
                    2->changeFragment(GuessFragment())
                }
                return true
            }
        }
    }

    private fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
    }
}


