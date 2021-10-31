package pri.guanhua.schedule.view

import android.os.Bundle
import android.view.View
import android.widget.NumberPicker
import androidx.fragment.app.Fragment
import pri.guanhua.schedule.R

class AddFragment : Fragment(R.layout.fragment_add) {

    private lateinit var timerPicker: NumberPicker

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        timePicker(view)
    }

    private fun timePicker(view: View){
        val inc_time: View = view.findViewById(R.id.inc_time)
        timerPicker = inc_time.findViewById(R.id.edit_time)
        timerPicker.maxValue = 10
        timerPicker.minValue = 1

    }

}