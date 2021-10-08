package com.example.mynotes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotes.data.Note;

import java.util.ArrayList;
import java.util.List;

public class AdapterNotes extends RecyclerView.Adapter<AdapterNotes.MyHolder> {
    private List<Note> notes = new ArrayList<>();


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notes_item, parent, false);
        return new MyHolder(itemView);    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Note currentNote = notes.get(position);
        holder.note.setText(currentNote.getNote());
        holder.time.setText(currentNote.getTime());
        holder.date.setText(currentNote.getDate());
        if (currentNote.getPriority()==1){
            holder.card.setBackgroundColor(holder.itemView.getResources().getColor(R.color.colorRed));
        }
    }


    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public Note getNoteAt(int position) {
        return notes.get(position);
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView note,time,date ;
        CardView card;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            note=itemView.findViewById(R.id.textview_title);
            time=itemView.findViewById(R.id.textView_not_time);
            date=itemView.findViewById(R.id.textView_note_date);
            card=itemView.findViewById(R.id.card);
        }
    }
}
