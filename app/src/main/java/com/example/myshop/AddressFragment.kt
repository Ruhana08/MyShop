package com.example.myshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class AddressFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.fragment_address,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        val spinnerProvinces =
            view.findViewById<Spinner>(R.id.spinnerProvinces)

        val btnDone =
            view.findViewById<Button>(R.id.btn_done)

        val provinces =
            resources.getStringArray(R.array.provinces)

        val adapterProvinces = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            provinces
        )

        adapterProvinces.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spinnerProvinces.adapter = adapterProvinces

        btnDone.setOnClickListener {
            findNavController().apply {
                previousBackStackEntry
                    ?.savedStateHandle
                    ?.set(
                        "address",
                        spinnerProvinces.selectedItem.toString()
                    )
            }.navigateUp()
        }
    }
}
