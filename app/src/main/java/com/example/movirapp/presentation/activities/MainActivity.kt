package com.example.movirapp.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.movirapp.R
import com.example.movirapp.databinding.ActivityMainBinding
import com.example.movirapp.presentation.fragments.MovieFragment
import com.example.movirapp.presentation.fragments.PersonFragment
import com.example.movirapp.presentation.fragments.SavedMovieFragment
import com.example.movirapp.presentation.fragments.SearchMovieFragment

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
         replaceFragment(MovieFragment())
        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId) {
                R.id.movie -> replaceFragment(MovieFragment())
                R.id.search -> replaceFragment(SearchMovieFragment())
                R.id.actors -> replaceFragment(PersonFragment())
                R.id.saved_movies -> replaceFragment(SavedMovieFragment())
                else -> {
                }
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction= fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }
}