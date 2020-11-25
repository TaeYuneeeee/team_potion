package com.example.swc_project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;

import org.json.JSONArray;

import java.util.ArrayList;

public class Adapter_petition extends RecyclerView.Adapter<Adapter_petition.ViewHolder> {
    private ArrayList<petition_Item> mData;
    private LayoutInflater mInflate;
    private Context mContext;
    final DatabaseReference databaseReference = null;
    private JSONArray dataSet;

    public Adapter_petition(Context context, ArrayList<petition_Item> persons){
        this.mContext = context;
        this.mInflate = LayoutInflater.from(context);
        this.mData = persons;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_petition_list, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DatabaseReference reference = null;
        petition_Item item = mData.get(position);

        final String sttitle = mData.get(position).getTitle();
        final String stbody = mData.get(position).getBody();
        final String key = mData.get(position).getKey();
        final String category = mData.get(position).getCategory();
        final int starcount = mData.get(position).getStarCount();
        final String tag1 = mData.get(position).getTag1();
        final String tag2 = mData.get(position).getTag2();
        final String tag3 = mData.get(position).getTag3();

        holder.textView1.setText(mData.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),petition_detail.class);
                intent.putExtra("title",sttitle);
                intent.putExtra("body",stbody);
                intent.putExtra("key",key);
                intent.putExtra("category",category);
                intent.putExtra("starcount",starcount);
                intent.putExtra("tag1",tag1);
                intent.putExtra("tag1",tag2);
                intent.putExtra("tag1",tag3);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (mData !=null?mData.size():0);
    }
    Adapter_petition(ArrayList<petition_Item> list) {
//        Adapter(ArrayList<Post> list) {
        mData = list ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.postTitle_petition);
        }
    }
}
