package com.techgod.mmchel.ui.two.three

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.list.rados.fast_list.bind
import com.techgod.mmchel.R
import com.techgod.mmchel.data.models.ThreeD
import kotlinx.android.synthetic.main.fragment_three_d.*
import kotlinx.android.synthetic.main.fragment_three_d.view.*
import kotlinx.android.synthetic.main.layout_item_three_d.view.tvDate
import kotlinx.android.synthetic.main.layout_item_three_d.view.tvResult

class ThreeDFragment : Fragment() {
    private  var resultList = mutableListOf<ThreeD>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_three_d, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.animationView.visibility=View.VISIBLE
        view.card.visibility=View.GONE
        //setUpRecycler()
    }

    private fun setUpRecycler(){
        dummyData()
        recyclerThreeD.bind(resultList,
            R.layout.layout_item_three_d
        ){ item, position ->
            bindDataToUi(item)
        }
    }

    private fun View.bindDataToUi(data : ThreeD){
        this.tvDate.text=data.date
        this.tvResult.text=data.result

    }

    private fun dummyData(){
        resultList.add(ThreeD("1-5-2020", "179"))
        resultList.add(ThreeD("1-5-2020", "179"))
        resultList.add(ThreeD("1-5-2020", "179"))
        resultList.add(ThreeD("1-5-2020", "179"))
        resultList.add(ThreeD("1-5-2020", "179"))
        resultList.add(ThreeD("1-5-2020", "179"))
        resultList.add(ThreeD("1-5-2020", "179"))
        resultList.add(ThreeD("1-5-2020", "179"))
        resultList.add(ThreeD("1-5-2020", "179"))
        resultList.add(ThreeD("1-5-2020", "179"))
        resultList.add(ThreeD("1-5-2020", "179"))
        resultList.add(ThreeD("1-5-2020", "179"))
    }
}
