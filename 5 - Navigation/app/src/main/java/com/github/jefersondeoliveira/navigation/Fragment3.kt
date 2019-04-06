package com.github.jefersondeoliveira.navigation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_3.*
import java.util.*


class Fragment3 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btGoOtherScreen.setOnClickListener{
            //without actions
            //Navigation.findNavController(it).navigate(R.id.navigation_screen4)

            //with actions
            //Navigation.findNavController(it).navigate(R.id.next_action)

            //with acions and args
//            val nextAction: Fragment3Directions.NextAction = Fragment3Directions.nextAction()
//            nextAction.setContNumber(Random().nextInt(200))
//
//            Navigation.findNavController(it).navigate(nextAction)

            //or
            Navigation.findNavController(it).navigate(Fragment3Directions.nextAction().run {
                setContNumber(Random().nextInt(200))
            })

        }
    }
}
