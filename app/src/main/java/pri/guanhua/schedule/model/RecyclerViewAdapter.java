package pri.guanhua.schedule.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import pri.guanhua.schedule.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.VH> {

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.timeHour.setText("23:43");
        holder.timeDate.setText("2021/10/8");
        holder.note.setText("为什么？因为这是我的责任！");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class VH extends RecyclerView.ViewHolder{

        public TextView timeHour;
        public TextView timeDate;
        public TextView note;

        public VH(@NonNull View itemView) {
            super(itemView);
            timeHour = itemView.findViewById(R.id.time_hour);
            timeDate = itemView.findViewById(R.id.time_date);
            note = itemView.findViewById(R.id.note);
        }
    }
}
