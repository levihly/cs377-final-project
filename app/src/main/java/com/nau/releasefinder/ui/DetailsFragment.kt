package com.nau.releasefinder.ui

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import coil.load
import com.nau.releasefinder.R
import com.nau.releasefinder.data.database.ReleaseDatabase
import com.nau.releasefinder.data.database.model.Release
import com.nau.releasefinder.data.repository.ReleaseRepository
import com.nau.releasefinder.ui.viewmodel.ReleaseViewModel
import com.nau.releasefinder.ui.viewmodel.ReleaseViewModelFactory
import org.w3c.dom.Text

class DetailsFragment : Fragment() {
    private lateinit var releaseViewModel: ReleaseViewModel
    private val args: DetailsFragmentArgs by navArgs()

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

        // get the release from the nav args
        val release: Release = args.release

        // references to UI elements
        val titleTextView: TextView = view.findViewById(R.id.titleText)
        val thumbImageView: ImageView = view.findViewById(R.id.musicReleaseImage)
        val backButton: Button = view.findViewById(R.id.backButton)
        val catNo: TextView = view.findViewById(R.id.catNumText)
        val yearText: TextView = view.findViewById(R.id.yearText)
        val origRelease: TextView = view.findViewById(R.id.releaseTextOrig)
        val reRelease: TextView = view.findViewById(R.id.releaseTextReissue)

        // use coil to load image
        thumbImageView.load(release.thumb)

        // fill the text views
        titleTextView.text = release.title
        catNo.text = release.catno
        yearText.text = release.year

        // if a repress or reissue according to the format list
        if(release.format.contains("Repress") || release.format.contains("Reissue")) {
            // make the original release text invisible, and the re-release text visible
            origRelease.visibility = View.INVISIBLE
            reRelease.visibility = View.VISIBLE
        }
        // otherwise, if an original release copy
        else {
            // make the original release text visible, and the re-release text invisible
            origRelease.visibility = View.VISIBLE
            reRelease.visibility = View.INVISIBLE
        }

        releaseViewModel.title.observe(viewLifecycleOwner) { title ->
            titleTextView.text = title
        }
    }
}