package com.examapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RealQuestionAdapter extends RecyclerView.Adapter<RealQuestionAdapter.ViewHolder> {
    private List<RealQuestion>realQuestionList;
    private  Context context;
    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        View box;
        public ViewHolder(View view){
            super(view);
            box=view;
          title=view.findViewById(R.id.real_question_title);
        }
    }
    public RealQuestionAdapter(List<RealQuestion>realQuestions){
        realQuestionList=realQuestions;

    }
    @NonNull
    @Override
    public RealQuestionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.real_question_item,parent,false);
      final ViewHolder holder=new ViewHolder(view);
        context=view.getContext();
        holder.box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                RealQuestion realQuestion=realQuestionList.get(position);

            }
        });
       return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RealQuestionAdapter.ViewHolder holder, int position) {
        RealQuestion title=realQuestionList.get(position);
        holder.title.setText(title.getTitle());
        context=holder.itemView.getContext();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
                Toast.makeText(context,"该功能暂时维护，请留意公告更新时间！",Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return realQuestionList.size();
    }
    private void dialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(context,R.style.shareDialog);
        final AlertDialog dialog=builder
                .setView(R.layout.dialog_warn_activity)
                .create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        dialog.getWindow().findViewById(R.id.yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().findViewById(R.id.no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}
