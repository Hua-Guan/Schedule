package pri.guanhua.schedule

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pri.guanhua.schedule.model.HomeRecyclerViewAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView : RecyclerView = view.findViewById(R.id.schedule_recyclerview)
        val lin = LinearLayoutManager(context)
        recyclerView.layoutManager = lin
        val adapter = HomeRecyclerViewAdapter()
        recyclerView.adapter = adapter
        val spaces = dp2px(4)
        val leftAndRight = dp2px(4)
        val space = HomeRecyclerViewAdapter.SpacesItemDecoration(spaces, leftAndRight)
        recyclerView.addItemDecoration(space)
    }

    private fun dp2px(dp: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(),
            resources.displayMetrics
        ).toInt()
    }

}