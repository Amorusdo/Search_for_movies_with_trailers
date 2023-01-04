package com.example.movirapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movirapp.databinding.FragmentPersonBinding
import com.example.movirapp.domain.models.movie.MovieDomain
import com.example.movirapp.presentation.adaptor.movie.MovieAdapter
import com.example.movirapp.presentation.viewModel.MovieDetailsViewModel
import com.example.movirapp.presentation.viewModel.MoviesViewModel
import com.example.movirapp.presentation.viewModel.PersonViewModel
import kotlinx.android.synthetic.main.fragment_person.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class PersonFragment : Fragment(),MovieAdapter.RecyclerOnClickListener,
    AdapterView.OnItemSelectedListener {

    private val binding: FragmentPersonBinding by lazy {
        FragmentPersonBinding.inflate(layoutInflater)
    }
    private val adaptor : MovieAdapter by lazy {
        MovieAdapter(MovieAdapter.PORTRAIT, this)
    }

    private val viewModel by viewModel<PersonViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { return binding.root }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvPerson.adapter = adaptor
    }
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemClick(movie: MovieDomain) {
        TODO("Not yet implemented")
    }

    override fun onSaveClick(movie: MovieDomain) {
        TODO("Not yet implemented")
    }


}