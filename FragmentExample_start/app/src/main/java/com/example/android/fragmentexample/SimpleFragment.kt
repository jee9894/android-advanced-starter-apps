package com.example.android.fragmentexample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SimpleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SimpleFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private val YES = 0
    private val NO = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_simple, container, false)
        val radioGroup: RadioGroup = rootView.findViewById(R.id.radio_group)
        val ratingBar: RatingBar = rootView.findViewById(R.id.ratingbar)

        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            val textView: TextView = rootView.findViewById(R.id.fragment_header)
            val radioButton: RadioButton = radioGroup.findViewById(i)
            val index = radioGroup.indexOfChild(radioButton)
            when(index){
                NO -> textView.setText(R.string.no_message)
                YES -> textView.setText(R.string.yes_message)
            }
        }

        ratingBar.setOnRatingBarChangeListener { ratingBar, fl, b ->
            Toast.makeText(context, "My Rating:${ratingBar.rating}", Toast.LENGTH_SHORT).show()
        }

        return rootView
    }

}