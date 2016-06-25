package com.sehalsein.footaballbookingadmin.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sehalsein.footaballbookingadmin.Pojo.AmenitiesDetail;
import com.sehalsein.footaballbookingadmin.Pojo.GroundInfo;
import com.sehalsein.footaballbookingadmin.Pojo.ManagerDetail;
import com.sehalsein.footaballbookingadmin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GroundDetail extends Fragment {

    private TextView mGroundName;
    private TextView mGroundType;
    private TextView mTiming;
    private TextView mMinimumTime;
    private TextView mMaximumTime;
    private TextView mPrice;
    private TextView mManager;
    private TextView mPhoneNumber;
    private TextView mAddress;

    private ImageView mWashroom;
    private ImageView mEquipmentRental;
    private ImageView mParking;
    private ImageView mDrinkingWater;
    private ImageView mSittingArea;
    private ImageView mChangingRoom;

    private DatabaseReference mDatabase;
    private String mKey;


    public GroundDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ground_detail, container, false);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        init(view);

        initUserDetail();
        //initGroundDetail();
        //initAmenities();


        return view;
    }

    private void initAmenities() {
        /*mDatabase.child("amenities").child(mKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                AmenitiesDetail amenities = dataSnapshot.getValue(AmenitiesDetail.class);
                setAmenities(amenities);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("ASD", "getUser:onCancelled", databaseError.toException());
            }
        });*/
        mDatabase.child(getResources().getString(R.string.amenities_list_id)).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.w("AMENITIES CHILD ", "ADDED");
                AmenitiesDetail amenities = dataSnapshot.getValue(AmenitiesDetail.class);
                try {
                    if (amenities.getKey().equals(mKey)) {
                        setAmenities(amenities);
                    }
                } catch (NullPointerException e) {

                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.w("AMENITIES CHILD ", "CHANGED");
                AmenitiesDetail amenities = dataSnapshot.getValue(AmenitiesDetail.class);
                try {
                    if (amenities.getKey().equals(mKey)) {
                        setAmenities(amenities);
                    }
                } catch (NullPointerException e) {

                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.w("AMENITIES CHILD ", "REMOVED");
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                Log.w("AMENITIES CHILD ", "MOVED");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("AMENITIES CHILD ", "CANCELEED");
            }
        });
    }

    private void setAmenities(AmenitiesDetail amenities) {
        if (amenities.isWashroom()) {
            mWashroom.setImageResource(R.drawable.vector_available);
        } else {
            mWashroom.setImageResource(R.drawable.vector_unavailable);
        }
        if (amenities.isEquipmentRental()) {
            mEquipmentRental.setImageResource(R.drawable.vector_available);
        } else {
            mEquipmentRental.setImageResource(R.drawable.vector_unavailable);
        }
        if (amenities.isChangingRoom()) {
            mChangingRoom.setImageResource(R.drawable.vector_available);
        } else {
            mChangingRoom.setImageResource(R.drawable.vector_unavailable);
        }
        if (amenities.isDrinkingWater()) {
            mDrinkingWater.setImageResource(R.drawable.vector_available);
        } else {
            mDrinkingWater.setImageResource(R.drawable.vector_unavailable);
        }
        if (amenities.isParking()) {
            mParking.setImageResource(R.drawable.vector_available);
        } else {
            mParking.setImageResource(R.drawable.vector_unavailable);
        }
        if (amenities.isSittingArea()) {
            mSittingArea.setImageResource(R.drawable.vector_available);
        } else {
            mSittingArea.setImageResource(R.drawable.vector_unavailable);
        }
    }

    private void initUserDetail() {
       /* mDatabase.child("users").child("qwe").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ManagerDetail user = dataSnapshot.getValue(ManagerDetail.class);
                mPhoneNumber.setText(user.getPhoneNumber());
                mManager.setText(user.getFirstName() + " " + user.getLastName());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("ASD", "getUser:onCancelled", databaseError.toException());
            }
        });*/

        mDatabase.child(getResources().getString(R.string.manager_list_id)).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.w("MANAGER CHILD ", "ADDED");
                ManagerDetail user = dataSnapshot.getValue(ManagerDetail.class);
                try {
                    if (user.getEmailId().equals("sehal@hotmail.com")) {
                        setUser(user);
                        initGroundDetail();
                        initAmenities();
                    }
                } catch (NullPointerException e) {

                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.w("USER CHILD ", "CHANGED");
                ManagerDetail user = dataSnapshot.getValue(ManagerDetail.class);
                try {
                    if (user.getEmailId().equals("sehal11@hotmail.com")) {
                        setUser(user);
                        //initGroundDetail();
                    }
                } catch (NullPointerException e) {

                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.w("USER CHILD ", "REMOVED");
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                Log.w("USER CHILD ", "MOVED");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("USER CHILD ", "CANCELEED");
            }
        });


    }

    private void initGroundDetail() {
       /*mDatabase.child("ground").child(mKey).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        GroundInfo user = dataSnapshot.getValue(GroundInfo.class);
                        mGroundType.setText(user.getGroundType());
                        mTiming.setText(user.getOpeningTime() + " - " + user.getClosingTime());
                        mMaximumTime.setText("user.getMaximumTime");
                        mMinimumTime.setText("user.getMinimumTime");
                        mPrice.setText(user.getPrice() + "");
                        mAddress.setText(user.getAddress());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w("ASD", "getUser:onCancelled", databaseError.toException());
                    }
                });*/

        mDatabase.child(getResources().getString(R.string.ground_list_id)).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.w("GROUND CHILD ", "ADDED");
                GroundInfo ground = dataSnapshot.getValue(GroundInfo.class);
                try {
                    if (ground.getKey().equals(mKey)) {
                        setGround(ground);
                    }
                } catch (NullPointerException e) {

                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.w("GROUND CHILD ", "CHANGED");
                GroundInfo ground = dataSnapshot.getValue(GroundInfo.class);
                try {
                    if (ground.getKey().equals(mKey)) {
                        setGround(ground);
                    }
                } catch (NullPointerException e) {

                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.w("GROUND CHILD ", "REMOVED");
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                Log.w("GROUND CHILD ", "MOVED");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("GROUND CHILD ", "CANCELEED");
            }
        });
    }

    private void setUser(ManagerDetail user) {
        mManager.setText(user.getFirstName() + " " + user.getLastName());
        mKey = user.getKey();
    }

    private void setGround(GroundInfo ground) {
        mGroundType.setText(ground.getGroundType());
        String opening = "AM";
        String closing = "AM";
        int openingHour = ground.getOpeningHour();
        int closingHour = ground.getClosingHour();
        if (openingHour > 12) {
            openingHour = openingHour - 12;
            opening = "PM";
        }
        if (closingHour > 12) {
            closingHour = closingHour - 12;
            closing = "PM";
        }
        mTiming.setText(openingHour + ":" + ground.getOpeningMinute() + " " + opening + " - " + closingHour + ":" + ground.getClosingMinute() + " " + closing);
        //mMaximumTime.setText("30 mins");
        mMinimumTime.setText("30 mins");
        mPrice.setText(ground.getPrice() + "");
        mAddress.setText(ground.getAddress());
    }

    private void init(View view) {
        mGroundType = (TextView) view.findViewById(R.id.text_ground_type);
        mTiming = (TextView) view.findViewById(R.id.text_timing);
        mMinimumTime = (TextView) view.findViewById(R.id.text_minimum_time);
        mMaximumTime = (TextView) view.findViewById(R.id.text_maximum_time);
        mPrice = (TextView) view.findViewById(R.id.text_price);
        mManager = (TextView) view.findViewById(R.id.text_manager);
        mPhoneNumber = (TextView) view.findViewById(R.id.text_phone_number);
        mAddress = (TextView) view.findViewById(R.id.text_address);

        mWashroom = (ImageView) view.findViewById(R.id.image_washroom);
        mEquipmentRental = (ImageView) view.findViewById(R.id.image_equipment_rental);
        mParking = (ImageView) view.findViewById(R.id.image_parking);
        mSittingArea = (ImageView) view.findViewById(R.id.image_sitting_area);
        mDrinkingWater = (ImageView) view.findViewById(R.id.image_drinking_water);
        mChangingRoom = (ImageView) view.findViewById(R.id.image_changing_room);
    }

}
