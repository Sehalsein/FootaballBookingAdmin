package com.sehalsein.footaballbookingadmin.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sehalsein.footaballbookingadmin.Adapter.BookingRequestAdapter;
import com.sehalsein.footaballbookingadmin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookingRequest extends Fragment {


    public BookingRequest() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_booking_request, container, false);

        initRecycler(view);

        return view;
    }

    private void initRecycler(View view) {
        RecyclerView recycler = (RecyclerView) view.findViewById(R.id.recycler_booking_request);
        recycler.setHasFixedSize(true);
        LinearLayoutManager linearLayout = new LinearLayoutManager(getActivity());
        linearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        BookingRequestAdapter adapter = new BookingRequestAdapter();
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(linearLayout);
    }

}
