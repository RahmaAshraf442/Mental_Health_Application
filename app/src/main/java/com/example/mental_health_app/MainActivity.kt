package com.example.mental_health_app

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mental_health_app.chat.view.ChatActivity
import com.example.mental_health_app.databinding.ActivityMainBinding
import com.example.paytabs_demo_store_android.onboarding.view.hide
import com.example.paytabs_demo_store_android.onboarding.view.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.incToolbar.tvToolbarTitle.text = getString(R.string.home)
        initBottomNavigationView()
        setContentView(binding.root)
        onClickActions()

    }



    private fun initBottomNavigationView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
        navController.addOnDestinationChangedListener { controller, destination, arguments ->

            binding.incToolbar.root.show()
            binding.incToolbar.ivSettings.show()
            when (destination.id) {
                R.id.navigation_home -> {
                    binding.incToolbar.tvToolbarTitle.text = "Home"
                    binding.coordinatorLayout.show()
                }
                R.id.navigation_journal -> {
                    binding.incToolbar.tvToolbarTitle.text = "Journal"
                    binding.coordinatorLayout.show()
                }
                R.id.navigation_yoga -> {
                    binding.incToolbar.tvToolbarTitle.text = "Meditation"
                    binding.coordinatorLayout.show()
                }
                R.id.navigation_profile -> {
                    binding.incToolbar.tvToolbarTitle.text = "Profile"
                    binding.coordinatorLayout.show()
                }
                R.id.navigation_settings -> {
                    binding.incToolbar.tvToolbarTitle.text = "Settings "
                    binding.coordinatorLayout.hide()
                    binding.incToolbar.ivSettings.hide()
                }
                else -> {
                    binding.coordinatorLayout.hide()
                }
            }
        }
        binding.bottomNavigatinView.setupWithNavController(navController)
    }

    private fun onClickActions() {
        binding.incToolbar.ivSettings.setOnClickListener {
            when (navController.currentDestination?.id) {
                R.id.navigation_home -> {
                    navController.navigate(R.id.action_navigation_home_to_navigation_settings)
                }
                R.id.navigation_yoga -> {
                    navController.navigate(R.id.action_navigation_yoga_to_navigation_settings)
                }
                R.id.navigation_profile -> {
                    navController.navigate(R.id.action_navigation_profile_to_navigation_settings)
                }
                R.id.navigation_journal -> {
                    navController.navigate(R.id.action_navigation_journal_to_navigation_settings)
                }
            }
        }
        binding.ivChatBot.setOnClickListener {
            val intent = Intent(this@MainActivity, ChatActivity::class.java)
            startActivity(intent)
        }
    }

}