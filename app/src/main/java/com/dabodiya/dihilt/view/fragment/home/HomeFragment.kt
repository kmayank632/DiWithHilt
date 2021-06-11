package com.dabodiya.dihilt.view.fragment.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dabodiya.dihilt.R
import com.dabodiya.dihilt.databinding.FragmentHomeBinding
import com.dabodiya.dihilt.base.BaseModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    /* ViewBinding Variable */
    private lateinit var binding: FragmentHomeBinding

    /* ViewModel Variable */
    private val viewModel: HomeVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        /* Inflate the layout for this fragment */
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
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
                viewModel.resourceProvider.getString(R.string.home)
            )
        )

        /* Clear SnackBar BackStack Problem*/
        viewModel.message.set("")

        /* Call Function */
        onClick()
    }

    /* Set Clicks */
    private fun onClick() {
        binding.loginButton.setOnClickListener {

            /* Call ViewModel Function */
            viewModel.result()

            /* Hide Keyboard */
            val inputManager: InputMethodManager =
                requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            val currentFocusedView = requireActivity().currentFocus
            if (currentFocusedView != null) {
                inputManager.hideSoftInputFromWindow(
                    currentFocusedView.windowToken,
                    InputMethodManager.HIDE_NOT_ALWAYS
                )
            }

        }
    }

}