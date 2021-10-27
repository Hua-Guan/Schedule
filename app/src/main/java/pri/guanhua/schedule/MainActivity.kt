package pri.guanhua.schedule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pri.guanhua.schedule.model.RecyclerViewAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView : RecyclerView = findViewById(R.id.schedule_recyclerview)
        val lin : LinearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = lin
        val adapter : RecyclerViewAdapter = RecyclerViewAdapter()
        val div : DividerItemDecoration = DividerItemDecoration(this, 1)
        //recyclerView.addItemDecoration(div)
        recyclerView.adapter = adapter
    }
}