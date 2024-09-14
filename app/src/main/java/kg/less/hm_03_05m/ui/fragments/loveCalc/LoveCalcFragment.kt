package kg.less.hm_03_05m.ui.fragments.loveCalc

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kg.less.hm_03_05m.LovePresenter
import kg.less.hm_03_05m.R
import kg.less.hm_03_05m.RetrofitService
import kg.less.hm_03_05m.databinding.FragmentLoveCalcBinding
import kg.less.hm_03_05m.databinding.FragmentResultBinding
import kg.less.hm_03_05m.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveCalcFragment : Fragment() {

    private lateinit var binding: FragmentLoveCalcBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoveCalcBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() = with(binding) {
        btnCal.setOnClickListener {
            RetrofitService.api.getPercent(
                firstName = etFname.text.toString(),
                secondName = etSname.text.toString()
            ).enqueue(object : Callback<LoveModel> {
                @SuppressLint("SuspiciousIndentation")
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful && response.body() != null) {
                        val result = response.body()
                        setFragmentResult(
                            "key", bundleOf(
                                "data" to result
                            )
                        )
                        findNavController().navigate(R.id.resultFragment)

                    }
                }
                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("fail", "onFailure: $t.error")
                }

            })
        }
    }

}