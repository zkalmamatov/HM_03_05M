package kg.less.hm_03_05m.ui.fragments.loveCalc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import kg.less.hm_03_05m.R
import kg.less.hm_03_05m.databinding.FragmentResultBinding
import kg.less.hm_03_05m.model.LoveModel

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillInTheData()
        initListener()
    }

    private fun fillInTheData() = with(binding) {
        setFragmentResultListener("key") {_, bundle ->
            val result = bundle.getSerializable("data") as? LoveModel
            fname.text = result?.firstName
            sname.text = result?.secondName
            score.text = result?.percentage
            tvResult.text = result?.result
        }
    }

    private fun initListener() {
        binding.btnAgain.setOnClickListener {
            findNavController().navigate(R.id.loveCalcFragment)
        }
    }
}