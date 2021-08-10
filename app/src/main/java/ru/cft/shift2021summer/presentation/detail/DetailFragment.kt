package ru.cft.shift2021summer.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.cft.shift2021summer.databinding.DetailFragmentBinding
import ru.cft.shift2021summer.domain.model.CountryData
import ru.cft.shift2021summer.listToStringConcat
import ru.cft.shift2021summer.mapToStringConcat

@AndroidEntryPoint
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DetailFragmentBinding.inflate(inflater)

        val application = requireNotNull(activity).application
        val countryData : CountryData = arguments?.get("DataStructure") as CountryData
        val viewModel : DetailViewModel by viewModels()

        viewModel.getArgumentsToVM(countryData)

        viewModel.selectedCountry.observe(viewLifecycleOwner, {
            binding.nameModDetail.text = it.name
            binding.capitalModDetail.text = it.capital
            binding.regionModDetail.text = it.region
//            binding.flagDetail
            // TODO("Добавить адптер для svg картинки")
            //binding.domainModDetail.text = listToStringConcat(it.topLevelDomain)
            binding.populationModDetail.text = it.population
            binding.areaModDetail.text = it.area?.toString() ?: "-"
            //binding.langModDetail.text = mapToStringConcat(it.languages)


        })



        return binding.root
    }
}