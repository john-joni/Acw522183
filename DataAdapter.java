package com.example.jonni.acw522183;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<Puzzle> Puzzlelist;
    public DataAdapter(ArrayList<Puzzle> PuzzleIndex) {
        this.Puzzlelist = PuzzleIndex;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_puzzle.setText(Puzzlelist.get(i).getPuzzle());
    }

    @Override
    public int getItemCount() {
        return Puzzlelist.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_puzzle;
        public ViewHolder(View view) {
            super(view);
            tv_puzzle = (TextView)view.findViewById(R.id.tv_puzzle);

        }
    }

}