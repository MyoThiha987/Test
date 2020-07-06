package com.techgod.mmchel.ui.two

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.techgod.mmchel.R
import com.techgod.mmchel.base.BaseViewModel
import com.techgod.mmchel.data.models.TwoD
import com.techgod.mmchel.utils.toDateStandard
import com.techgod.mmchel.utils.toTimeStandardIn12Hours
import kotlinx.android.synthetic.main.fragment_two_d.*
import kotlinx.android.synthetic.main.layout_item_afternoon.*
import kotlinx.android.synthetic.main.layout_item_evening.*
import kotlinx.android.synthetic.main.layout_item_mid_afternoon.*
import kotlinx.android.synthetic.main.layout_item_morning.tvApkValue
import kotlinx.android.synthetic.main.layout_item_morning.tvInternetValue
import kotlinx.android.synthetic.main.layout_item_morning.tvModernValue
import kotlinx.android.synthetic.main.layout_item_morning.tvTime
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class TwoDFragment : Fragment() {
    private lateinit var simpleDateFormat:SimpleDateFormat
    private lateinit var viewModel: TwoDViewModel
    private lateinit var networkViewModel : BaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_two_d, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()

        networkViewModel.getNetworLiveData(requireContext()).observe(viewLifecycleOwner, Observer {

            if(it==true){
                viewModel.getTwoDResult()
                viewModel.viewState.observe(viewLifecycleOwner, Observer {
                    render(it)
                })
            }
            else{
                hideView()
            }
        })
        bindDashBoardToData()
    }

    private fun setUpViewModel(){
        viewModel = ViewModelProviders.of(this).get(TwoDViewModel::class.java)
        networkViewModel= ViewModelProviders.of(this).get(BaseViewModel::class.java)
    }

    private fun render(state: TwoDViewState){
        when(state){
            is TwoDViewState.LoadingFetState-> renderTwoDDataLoading()
            is TwoDViewState.SuccessFetchState-> renderTwoDDataSuccess(state)
            is TwoDViewState.FailFetchState-> renderTwoDDataFail(state)
        }
    }

    private fun renderTwoDDataLoading() {
        hideView()
    }

    private fun renderTwoDDataSuccess(state: TwoDViewState.SuccessFetchState) {
        showView()
        bindTwoDResultToUI(state.data)
    }

    private fun renderTwoDDataFail(state: TwoDViewState.FailFetchState) {
        hideView()
    }

    private fun bindDashBoardToData(){
        /*val st ="2020-06-04T22:32:02"
        var pattern = "yyyy-MM-dd'T'HH:mm:ss"
        var date = SimpleDateFormat(pattern).parse(st)
        */
        val st = "11\\/06\\/2020 14:36:42"
        var pattern = "dd'\\'/MM'\\'/yyyy HH:mm:ss"
        var date = SimpleDateFormat(pattern, Locale.getDefault()).parse(st)
        tvDate.text=date.toDateStandard()
        tvClock.text=date.toTimeStandardIn12Hours()

    }

    private fun bindTwoDResultToUI(it:TwoD){
        this.tvTime.text = it.nine_time
        this.tvApkValue.text = it.nine_apk
        this.tvModernValue.text = it.nine_modern
        this.tvInternetValue.text = it.nine_internet
        this.tvTimes.text = it.noon_time
        this.tvThreeDValue.text = it.noon_d3
        this.tvTwoDValue.text = it.noon_d2
        this.tvTimeNoon.text =it.two_time
        this.tvApkValueNoon.text = it.two_apk
        this.tvModernValueNoon.text = it.two_modern
        this.tvInternetValueNoon.text = it.two_internet
        this.tvTimeEve.text = it.eve_time
        this.tvThreeDValueEve.text = it.eve_d3
        this.tvTwoDValueEve.text = it.eve_d2
    }

    private fun showView(){
        animationView.visibility=View.GONE
        scroll.visibility=View.VISIBLE
        card.visibility=View.VISIBLE
        tvZayKwat.visibility=View.VISIBLE
    }

    private fun hideView(){
        animationView.visibility=View.VISIBLE
        scroll.visibility=View.GONE
        card.visibility=View.GONE
        tvZayKwat.visibility=View.GONE
    }

    override fun onResume() {
        super.onResume()
        networkViewModel.getNetworLiveData(requireContext()).observe(viewLifecycleOwner, Observer {
            if(it==true){
                viewModel.getTwoDResult()
                viewModel.viewState.observe(viewLifecycleOwner, Observer {
                    render(it)
                })
            }
            else{
                hideView()
            }
        })
    }
}
