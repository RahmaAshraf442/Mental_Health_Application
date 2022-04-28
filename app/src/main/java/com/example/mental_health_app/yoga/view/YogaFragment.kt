package com.example.mental_health_app.yoga.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mental_health_app.R
import com.example.mental_health_app.databinding.FragmentYogaBinding
import com.example.mental_health_app.yoga.model.YogaModel
import com.example.mental_health_app.yoga.view.adapter.YogaAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class YogaFragment : Fragment() {

    private lateinit var binding: FragmentYogaBinding
    private lateinit var adapter :YogaAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentYogaBinding.inflate(inflater)
        val data = ArrayList<YogaModel>()
        for (i in 1..10){
            data.add(YogaModel("Name","Description" , R.drawable.day1))
        }
        adapter= YogaAdapter(data)
        binding.rvYoga.layoutManager=LinearLayoutManager(context)
        binding.rvYoga.adapter=adapter
        return binding.root

    }

}