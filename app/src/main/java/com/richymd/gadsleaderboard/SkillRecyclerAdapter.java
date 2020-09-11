package com.richymd.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.richymd.gadsleaderboard.data.SkillIq;

import java.util.ArrayList;

public class SkillRecyclerAdapter extends RecyclerView.Adapter<SkillRecyclerAdapter.ViewHolder> {

    private final ArrayList<SkillIq> mSkillData;
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;

    public SkillRecyclerAdapter(Context context, ArrayList<SkillIq> skillData) {
        mSkillData = skillData;
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

        SkillIq skillIq = mSkillData.get(position);
        holder.mLearnerBadge.setImageResource(R.drawable.skill_iq_trimmed);
        holder.mLearnerName.setText(skillIq.getName());
        holder.mLearnerDetails.setText(String.format("%s%s%s", skillIq.getScore(), mContext.getString(R.string.skill_iq_score), skillIq.getCountry()));
        holder.mCurrentPosition = position;
    }

    @Override
    public int getItemCount() {
        return mSkillData.size();
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