package com.nure.pz3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nure.pz3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AgeFragment())
                .commit()
            binding.bottomNav.selectedItemId = R.id.nav_age
        }

        binding.bottomNav.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.nav_age -> AgeFragment()
                R.id.nav_seconds -> SecondsFragment()
                R.id.nav_rps -> RpsFragment()
                R.id.nav_prime -> PrimeFragment()
                else -> return@setOnItemSelectedListener false
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
            true
        }
    }
}
