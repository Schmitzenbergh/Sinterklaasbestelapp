package com.smir.sinterklaas

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import java.io.OutputStreamWriter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [summary.newInstance] factory method to
 * create an instance of this fragment.
 */
class summary : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_summary, container, false)

        view.findViewById<TextView>(R.id.summary_txt_length).text = arguments?.getString("length", "geen")
        view.findViewById<TextView>(R.id.summary_txt_amount).text = arguments?.getString("amount", "geen")
        view.findViewById<TextView>(R.id.summary_txt_other).text = arguments?.getString("other", "geen")

        view.findViewById<Button>(R.id.summary_btn_done).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_summary_to_landing)
        }
        playSound()

        return view

    }


     private fun playSound(){
         val mediaPlayer = MediaPlayer.create(context, R.raw.tada)
         mediaPlayer.start() // no need to call prepare(); create() does that for yo
     }

    private fun saveData(){
        //https://stackoverflow.com/questions/45193941/how-to-read-and-write-txt-files-in-android-in-kotlin
        


    }
}