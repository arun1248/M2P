package com.arun1248.m2p.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.arun1248.m2p.R
import com.arun1248.m2p.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val host = supportFragmentManager
            .findFragmentById(R.id.appNavHost) as NavHostFragment? ?: return


        host.navController.let { binding.bottomNavMainAct.setupWithNavController(it) }
    }
}