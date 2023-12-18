package com.smir.sinterklaas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [signup.newInstance] factory method to
 * create an instance of this fragment.
 */
class signup : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_signup, container, false)

        view.findViewById<Button>(R.id.signup_btn_back).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_signup_to_landing)
        }

        view.findViewById<Button>(R.id.signup_btn_order).setOnClickListener{

            if(checkInput()) {

                val length = view.findViewById<TextView>(R.id.signup_txt_length).text.toString()
                val amount = view.findViewById<TextView>(R.id.signup_txt_amount).text.toString()
                val other = view.findViewById<TextView>(R.id.signup_txt_other).text.toString()

                val bundle = bundleOf("length" to length, "amount" to amount, "other" to other)
                Navigation.findNavController(view).navigate(R.id.action_signup_to_summary, bundle)
            }
        }
        return view
    }

     fun checkInput(): Boolean {
         return true

     }

}