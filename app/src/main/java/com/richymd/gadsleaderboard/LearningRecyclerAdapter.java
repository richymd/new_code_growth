package com.richymd.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.richymd.gadsleaderboard.data.LearningHours;

import java.util.ArrayList;

public class LearningRecyclerAdapter extends RecyclerView.Adapter<LearningRecyclerAdapter.ViewHolder> {

    private final ArrayList<LearningHours> mLearningData;
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;

    public LearningRecyclerAdapter(Context context, ArrayList<LearningHours> learningData) {
        mLearningData = learningData;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        LearningHours learningHours = mLearningData.get(position);
        holder.mLearnerBadge.setImageResource(R.drawable.top_learner);
        holder.mLearnerName.setText(learningHours.getName());
        holder.mLearnerDetails.setText(learningHours.getHours() + " learning hours, " + learningHours.getCountry());
        holder.mCurrentPosition = position;
    }

    @Override
    public int getItemCount() {
        return mLearningData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mLearnerName;
        public final TextView mLearnerDetails;
        public final ImageView mLearnerBadge;
        public int mCurrentPosition;

        public ViewHolder(View itemView) {
            super(itemView);
            mLearnerName = itemView.findViewById(R.id.name);
            mLearnerDetails = itemView.findViewById(R.id.tv_learning_details);
            mLearnerBadge = itemView.findViewById(R.id.imageView_badge);
        }

    }
}
