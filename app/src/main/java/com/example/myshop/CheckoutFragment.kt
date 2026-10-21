
package com.example.myshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class CheckoutFragment : Fragment() {

    private val args: CheckoutFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_checkout,
            container,
            false
        )

        // Mengambil nama produk dari HomeFragment
        val txtProductName =
            view.findViewById<TextView>(R.id.txtProductName)

        txtProductName.text = args.productName

        // Mengambil kolom alamat
        val edtAddress =
            view.findViewById<EditText>(R.id.edt_address)

        // Membuka AddressFragment saat kolom alamat diklik
        edtAddress.setOnClickListener {
            val action =
                CheckoutFragmentDirections
                    .actionCheckoutFragmentToAddressFragment3()

            findNavController().navigate(action)
        }


        findNavController().currentBackStackEntry
            ?.savedStateHandle
            ?.getLiveData<String>("address")
            ?.observe(viewLifecycleOwner) { res ->
                edtAddress.setText(res)
            }

        val btnDone =
            view.findViewById<Button>(R.id.btn_done)

        btnDone.setOnClickListener {
            findNavController().navigateUp()
        }


        return view
    }
}
