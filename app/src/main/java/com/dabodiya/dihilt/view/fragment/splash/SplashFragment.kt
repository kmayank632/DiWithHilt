package com.dabodiya.dihilt.view.fragment.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dabodiya.dihilt.R
import com.dabodiya.dihilt.base.BaseModel
import com.dabodiya.dihilt.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {

    /* ViewBinding Variable */
    lateinit var binding: FragmentSplashBinding

    /* Time delay Variable */
    private val time: Long = 2 * 1000 /* 2 Seconds */

    /* ViewModel Variable */
    private val viewModel: SplashVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_splash, container, false
        )
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* Hide Toolbar */
        viewModel.eventListener.showToolBar(BaseModel())


        /* Handler For Delay*/
        Handler(Looper.getMainLooper()).postDelayed({

            /* Navigate */
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }, time)
    }

}