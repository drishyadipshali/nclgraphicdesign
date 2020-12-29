package com.drishya.nucleusacademygraphic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class courseAdapter extends RecyclerView.Adapter<courseAdapter.courseViewHolder> {
    String s1[], s2[];
    Context context;
    int img[];
    public onCourseListener mCourseListener;

    public courseAdapter(Context ctxt, String s1[], String s2[], int img[], onCourseListener mCourseListener) {
        context = ctxt;
        this.s1 = s1;
        this.s2 = s2;
        this.img = img;
        this.mCourseListener = mCourseListener;
    }

    @NonNull
    @Override
    public courseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.courseitem, parent, false);
        return new courseViewHolder(view, mCourseListener);
    }

    @Override
    public void onBindViewHolder(@NonNull courseViewHolder holder, int position) {
        holder.tex1.setText(s1[position]);
        holder.text2.setText(s2[position]);
        holder.img.setImageResource(img[position]);

    }

    @Override
    public int getItemCount() {

        return s1.length;
    }

    public class courseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        TextView tex1, text2;
        onCourseListener onCourseListener;

        public courseViewHolder(@NonNull View itemView, onCourseListener onCourseListener) {
            super(itemView);

            tex1 = (TextView) itemView.findViewById(R.id.text1);
            text2 = (TextView) itemView.findViewById(R.id.text2);
            img = (ImageView) itemView.findViewById(R.id.img);
            this.onCourseListener = onCourseListener;
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            onCourseListener.onCourseClick(getAdapterPosition());
        }
    }

    public interface onCourseListener {
        void onCourseClick(int position);
    }

}
