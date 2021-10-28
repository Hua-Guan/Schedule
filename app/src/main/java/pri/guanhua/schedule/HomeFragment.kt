package pri.guanhua.schedule

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pri.guanhua.schedule.model.HomeRecyclerViewAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView : RecyclerView = view.findViewById(R.id.schedule_recyclerview)
        val lin = LinearLayoutManager(context)
        recyclerView.layoutManager = lin
        val adapter = HomeRecyclerViewAdapter()
        recyclerView.adapter = adapter
        val spaces = 88
        val space = HomeRecyclerViewAdapter.SpacesItemDecoration(spaces)
        recyclerView.addItemDecoration(space)
    }
}