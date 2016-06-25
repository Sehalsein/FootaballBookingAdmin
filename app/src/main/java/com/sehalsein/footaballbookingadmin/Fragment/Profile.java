package com.sehalsein.footaballbookingadmin.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sehalsein.footaballbookingadmin.Adapter.ProfileAdapter;
import com.sehalsein.footaballbookingadmin.Pojo.ProfileSetting;
import com.sehalsein.footaballbookingadmin.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment {


    public Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        initRecyler(view);

        return view;
    }

    private void initRecyler(View view) {
        RecyclerView recycler = (RecyclerView) view.findViewById(R.id.recycler_profile_list);
        recycler.setHasFixedSize(true);
        LinearLayoutManager linearlayout = new LinearLayoutManager(getContext());
        linearlayout.setOrientation(LinearLayoutManager.VERTICAL);
        ProfileAdapter adapter = new ProfileAdapter(getActivity(), createList());
        // adapter.setClickListener(this);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(linearlayout);
    }

    private List<ProfileSetting> createList() {
        List<ProfileSetting> list = null;
        try {
            String Title[] = {"Booking History", "Settings", "Terms & Condition"};
            //int Icon[] = {R.drawable.vector_history, R.drawable.vector_settings, R.drawable.vector_contract};
            list = new ArrayList<ProfileSetting>();
            for (int i = 0; i < Title.length; i++) {
                ProfileSetting profileSetting = new ProfileSetting();
                profileSetting.setText(Title[i]);
                // profileSetting.setIcon(Icon[i]);
                list.add(profileSetting);
            }
        } catch (Exception e) {
            System.out.print(e);
        }
        return list;
    }

}
