package com.nau.releasefinder.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.nau.releasefinder.R
import com.nau.releasefinder.data.database.ReleaseDatabase
import com.nau.releasefinder.data.repository.ReleaseRepository
import com.nau.releasefinder.ui.viewmodel.ReleaseViewModel
import com.nau.releasefinder.ui.viewmodel.ReleaseViewModelFactory

// home fragment class
class HomeFragment : Fragment() {
    // create variables for the view model and navigation controller
    private lateinit var releaseViewModel: ReleaseViewModel

    // on view creation
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // set up the view
        val application = requireActivity().application
        val releaseDatabase = ReleaseDatabase.getInstance(application)
        val repository = ReleaseRepository(releaseDatabase.releaseDao())
        val factory = ReleaseViewModelFactory(repository)
        releaseViewModel = ViewModelProvider(this, factory).get(ReleaseViewModel::class.java)

        // inflate the XML file
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    // once view created
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // get the various views
        val searchText: EditText = view.findViewById(R.id.et_search_box)
        val submitButton: Button = view.findViewById(R.id.btn_submit)

        // listen for a submit button click
        submitButton.setOnClickListener {
            // get the search field text
            val search = searchText.text.toString().trim()

            // if not empty, search for the release
            if( search.isNotEmpty() ) {
                releaseViewModel.fetchRelease(search)
            }
            // otherwise if empty, let the user know they need to fill in the search bar
            else {
                Toast.makeText(requireContext(), "Error: Please enter a catalog number", Toast.LENGTH_SHORT).show()
            }
        }
    }
}