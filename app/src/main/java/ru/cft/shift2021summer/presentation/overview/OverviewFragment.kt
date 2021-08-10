package ru.cft.shift2021summer.presentation.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.databinding.FragmentOverviewBinding

@AndroidEntryPoint
class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentOverviewBinding.inflate(inflater)

        val adapter = CountryLinearAdapter(CountryLinearAdapter.OnClickListener {
            viewModel.displayCountryDetails(it)
        })

        binding.countryList.adapter = adapter
        viewModel.listCountries.observe(viewLifecycleOwner, {
            it?.let { adapter.submitList(it) }
        })

        viewModel.navigateToSelectedCountry.observe(viewLifecycleOwner, {
            if (null != it) {
                findNavController()
                    .navigate(
                        R.id.action_overviewFragment_to_detailFragment,
                        bundleOf("DataStructure" to it)
                    )
                viewModel.displayCountryDetailsComplete()
            }
        })

        return binding.root
    }
}