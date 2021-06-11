package com.dabodiya.dihilt.view.fragment.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dabodiya.dihilt.R
import com.dabodiya.dihilt.base.BaseModel
import com.dabodiya.dihilt.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    /* ViewBinding Variable */
    private lateinit var binding: FragmentProfileBinding

    /* ViewModel Variable */
    private val viewModel: ProfileVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        /* Inflate the layout for this fragment */
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_profile, container, false
        )
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* Show Toolbar */
        viewModel.eventListener.showToolBar(
            BaseModel(
                true,
                viewModel.resourceProvider.getString(R.string.my_profile)
            )
        )

        /* Call ViewModel Function */
        viewModel.getSumForProfile()
    }

}