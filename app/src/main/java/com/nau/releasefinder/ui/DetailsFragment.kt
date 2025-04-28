package com.nau.releasefinder.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nau.releasefinder.R
import com.nau.releasefinder.data.database.ReleaseDatabase
import com.nau.releasefinder.data.repository.ReleaseRepository
import com.nau.releasefinder.ui.viewmodel.ReleaseViewModel
import com.nau.releasefinder.ui.viewmodel.ReleaseViewModelFactory

class DetailsFragment : Fragment() {
    private lateinit var releaseViewModel: ReleaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireActivity().application
        val releaseDatabase = ReleaseDatabase.getInstance(application)
        val repository = ReleaseRepository(releaseDatabase.releaseDao())
        val factory = ReleaseViewModelFactory(repository)
        releaseViewModel = ViewModelProvider(this, factory).get(ReleaseViewModel::class.java)

        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // references to UI elements
        val titleTextView = view.findViewById<TextView>(R.id.titleText)
        val thumbImageView = view.findViewById<ImageView>(R.id.musicReleaseImage)

        releaseViewModel.title.observe(viewLifecycleOwner) { title ->
            titleTextView.text = title
        }
    }
}