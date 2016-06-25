package com.sehalsein.footaballbookingadmin.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sehalsein.footaballbookingadmin.Pojo.ProfileSetting;
import com.sehalsein.footaballbookingadmin.R;

import java.util.List;

/**
 * Created by sehalsein on 23/06/16.
 */
public class ProfileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ProfileSetting> list;
    private static final int HEADER = 0;
    private static final int OTHER = 0;

    public ProfileAdapter() {
    }

    public ProfileAdapter(Context context, List<ProfileSetting> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View headerlayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_profile_header, parent, false);
            return new HeaderViewHolder(headerlayout);
        } else {
            View settingslayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_profile_list, parent, false);
            return new SettingsViewHolder(settingslayout);
        }
    }

    public int getItemViewType(int position) {
        return position + 1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder.getItemViewType() == 1) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;

        } else {
            ProfileSetting setting = list.get(position - 1);
            SettingsViewHolder settingsViewHolder = (SettingsViewHolder) holder;
            settingsViewHolder.mSettingText.setText("" + setting.getText());
            //settingsViewHolder.mSettingIcon.setImageResource(setting.getIcon());
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    public class SettingsViewHolder extends RecyclerView.ViewHolder {
        ImageView mSettingIcon;
        TextView mSettingText;
        ImageView mImageNext;

        public SettingsViewHolder(View itemView) {
            super(itemView);
            mSettingIcon = (ImageView) itemView.findViewById(R.id.image_settings);
            mSettingText = (TextView) itemView.findViewById(R.id.text_settings);
            mImageNext = (ImageView) itemView.findViewById(R.id.image_next);
        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {

        ImageView mProfilePic;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            mProfilePic = (ImageView) itemView.findViewById(R.id.image_profile_pic);
        }
    }

}
