package com.dabodiya.dihilt.view.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dabodiya.dihilt.R
import com.dabodiya.dihilt.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    /* View Binding */
    lateinit var binding: ActivityMainBinding

    /* ViewModel Variable */
    private val viewModel: MainActivityVM by viewModels()

    /* For Navigation Control */
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.fragment_container)
        binding.bottomNavigation.setOnNavigationItemSelectedListener(navListener)
        binding.viewModel = viewModel

        /** Bottom Navigation Show and Hide  */
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment -> {
                    binding.bottomNavigation.visibility = View.GONE
                }
                R.id.profileFragment, R.id.homeFragment -> {
                    binding.bottomNavigation.visibility = View.VISIBLE
                }

            }
        }
        observe()
    }

    /** Bottom Navigation Item Click*/
    private val navListener: BottomNavigationView.OnNavigationItemSelectedListener =
        object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.home ->
                        if (navController.currentDestination?.id != R.id.homeFragment) {
                            navController.navigate(R.id.homeFragment)
                            return true
                        }
                    R.id.myProfile ->
                        if (navController.currentDestination?.id != R.id.profile_navigation_graph) {
                            navController.navigate(R.id.profile_navigation_graph)
                            return true
                        }

                }
                return true

            }

        }

    private fun observe() {

        /* Observe to Show/Hide ToolBar */
        viewModel.eventListener.getToolBarVisibilityLD().observe(this, { showStatus ->
            when (showStatus.status) {
                true -> {
                    setToolBarTitle(showStatus.message)
                    showActionBar()
                }
                else -> hideActionBar()
            }
        })
    }

    override fun onBackPressed() {

        /* Check Home Id on Back */
        if (navController.currentDestination?.id == R.id.homeFragment) {
            finish()
        } else {
            navController.navigate(R.id.homeFragment)
        }

    }

    /**
     * Change Toolbar Title
     * */
    private fun setToolBarTitle(title: String) {
        viewModel.toolBarTitle.set(title.trim())
    }

    /**
     * Show Toolbar
     * */
    private fun hideActionBar() {
        binding.appBarLayout.visibility = View.GONE
    }

    /**
     * Hide Toolbar
     * */
    private fun showActionBar() {
        binding.appBarLayout.visibility = View.VISIBLE
    }
}