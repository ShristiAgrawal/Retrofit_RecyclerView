package com.example.retrofit_rv;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context context;
   // private RetroPhoto r;
   // private List<RetroPhoto> list;
    private List<movie> mlist;

    public CustomAdapter(Context context, List<movie> mlist) {
        this.context = context;
        this.mlist = mlist;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //mlist=r.getMovies();

        View v= LayoutInflater.from(context).inflate(R.layout.items,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Toast.makeText(context, "heya", Toast.LENGTH_SHORT).show();

        viewHolder.t1.setText(String.valueOf(mlist.get(i).getId()));
      //  mlist=list.get(i).getMovies();
//viewHolder.t1.setText(mlist.get(i).getId());
        //Glide.with(context).load(list.get(i).getThumbnailUrl()).apply(RequestOptions.circleCropTransform()).into(viewHolder.i1);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView t1;
        ImageView i1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.tv);
           // i1=itemView.findViewById(R.id.iv);


        }
    }
}
