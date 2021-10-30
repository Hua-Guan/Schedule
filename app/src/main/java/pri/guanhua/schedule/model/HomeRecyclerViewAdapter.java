package pri.guanhua.schedule.model;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import pri.guanhua.schedule.R;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.VH> {

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.time.setText("23:43  2021/10/27");
        holder.note.setText("为什么？因为这是我的责任！");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class VH extends RecyclerView.ViewHolder{

        public TextView time;
        public TextView note;

        public VH(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            note = itemView.findViewById(R.id.note);
        }
    }

    public static class SpacesItemDecoration extends RecyclerView.ItemDecoration{

        private int space;
        private int leftAndRight;

        public SpacesItemDecoration(int space, int leftAndRight) {
            this.space = space;
            this.leftAndRight = leftAndRight;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);

            outRect.bottom = space;
            outRect.left = leftAndRight;
            outRect.right = leftAndRight;
            outRect.top = space;

        }

    }
}
