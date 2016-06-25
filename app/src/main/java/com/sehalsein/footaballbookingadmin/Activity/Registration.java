package com.sehalsein.footaballbookingadmin.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.codetroopers.betterpickers.radialtimepicker.RadialTimePickerDialogFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sehalsein.footaballbookingadmin.Pojo.AmenitiesDetail;
import com.sehalsein.footaballbookingadmin.Pojo.GroundInfo;
import com.sehalsein.footaballbookingadmin.Pojo.ManagerDetail;
import com.sehalsein.footaballbookingadmin.R;

public class Registration extends AppCompatActivity {

    //Layout
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mEmail;
    private EditText mPassword;
    private EditText mPhoneNumber;
    private EditText mGroundName;
    private EditText mPrice;
    private EditText mOpeningTime;
    private EditText mClosingTime;
    private EditText mAddress;
    private CheckBox mWashroom;
    private CheckBox mEquipmentRental;
    private CheckBox mSittingArea;
    private CheckBox mDrinkingWater;
    private CheckBox mParking;
    private CheckBox mChangingRoom;
    private CheckBox mAgreement;
    private Button mRegister;

    //Variable
    private String firstName, lastName, emailId, groundName, address, password;
    private int openingHour, openingMinute, closingHour, closingMinute;
    private String phonenumber;
    private double price;
    private boolean washroom, equipmentRental, sittingArea, drinkingWater, parking, changingRoom, agreement;


    //Firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mDatabase;
    private String mKey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();
        init();

        if (mAgreement.isChecked()) {
            agreement = true;
        } else {
            agreement = false;
        }
        int startTime = 10;
        int endTime = 20;

        for (int i = startTime; i < endTime; i++) {
            int y = i + 1;
            Log.e("CHECKING ", i + " - " + y);
        }


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("Check ", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d("Check ", "onAuthStateChanged:signed_out");
                }
            }
        };
        mDatabase = FirebaseDatabase.getInstance().getReference();


    }

    private void init() {
        mFirstName = (EditText) findViewById(R.id.edittext_first_name);
        mLastName = (EditText) findViewById(R.id.edittext_last_name);
        mEmail = (EditText) findViewById(R.id.edittext_email);
        mPassword = (EditText) findViewById(R.id.edittext_password);
        mPhoneNumber = (EditText) findViewById(R.id.edittext_phone_number);
        mGroundName = (EditText) findViewById(R.id.edittext_ground_name);
        mPrice = (EditText) findViewById(R.id.edittext_price);
        mOpeningTime = (EditText) findViewById(R.id.edittext_opening_time);
        mClosingTime = (EditText) findViewById(R.id.edittext_closing_time);
        mAddress = (EditText) findViewById(R.id.edittext_address);
        mWashroom = (CheckBox) findViewById(R.id.checkbox_washroom);
        mEquipmentRental = (CheckBox) findViewById(R.id.checkbox_equipment_rental);
        mSittingArea = (CheckBox) findViewById(R.id.checkbox_sitting_area);
        mDrinkingWater = (CheckBox) findViewById(R.id.checkbox_drinking_water);
        mParking = (CheckBox) findViewById(R.id.checkbox_parking);
        mChangingRoom = (CheckBox) findViewById(R.id.checkbox_changing_room);
        mAgreement = (CheckBox) findViewById(R.id.checkbox_agreement);
        mRegister = (Button) findViewById(R.id.button_register);
    }

    public void openingTime(View view) {
        RadialTimePickerDialogFragment rtpd = new RadialTimePickerDialogFragment()
                .setOnTimeSetListener(new RadialTimePickerDialogFragment.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(RadialTimePickerDialogFragment dialog, int hourOfDay, int minute) {
                        //Toast.makeText(Registration.this, "Restaurant opens at " + hourOfDay + " : " + minute, Toast.LENGTH_SHORT).show();
                        mOpeningTime.setText(hourOfDay + " : " + minute);
                        openingHour = hourOfDay;
                        openingMinute = minute;


                    }
                })
                .setStartTime(10, 10)
                .setDoneText("Set Time")
                .setCancelText("Cancel");
        rtpd.show(getSupportFragmentManager(), "Pick Opening Time");

    }

    public void closingTime(View view) {
        RadialTimePickerDialogFragment rtpd = new RadialTimePickerDialogFragment()
                .setOnTimeSetListener(new RadialTimePickerDialogFragment.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(RadialTimePickerDialogFragment dialog, int hourOfDay, int minute) {
                        //Toast.makeText(Registration.this, "Restaurant opens at " + hourOfDay + " : " + minute, Toast.LENGTH_SHORT).show();
                        mClosingTime.setText(hourOfDay + " : " + minute);
                        closingHour = hourOfDay;
                        closingMinute = minute;
                    }
                })
                .setStartTime(10, 10)
                .setDoneText("Set Time")
                .setCancelText("Cancel");
        rtpd.show(getSupportFragmentManager(), "Pick Closing Time");

    }

    public void register(View view) {
        boolean validation = validate();
        if (validation) {

            firstName = mFirstName.getText().toString();
            lastName = mLastName.getText().toString();
            emailId = mEmail.getText().toString();
            password = mPassword.getText().toString();
            groundName = mGroundName.getText().toString();
            address = mAddress.getText().toString();
            phonenumber = mPhoneNumber.getText().toString();
            price = Integer.parseInt(mPrice.getText().toString());

            if (mWashroom.isChecked()) {
                washroom = true;
            } else {
                washroom = false;
            }
            if (mEquipmentRental.isChecked()) {
                equipmentRental = true;
            } else {
                equipmentRental = false;
            }
            if (mSittingArea.isChecked()) {
                sittingArea = true;
            } else {
                sittingArea = false;
            }
            if (mDrinkingWater.isChecked()) {
                drinkingWater = true;
            } else {
                drinkingWater = false;
            }
            if (mParking.isChecked()) {
                parking = true;
            } else {
                parking = false;
            }
            if (mChangingRoom.isChecked()) {
                changingRoom = true;
            } else {
                changingRoom = false;
            }

            Log.d("Registraion ", " Successfull");
            Toast.makeText(Registration.this, "Redistration successfull", Toast.LENGTH_SHORT).show();
            //createAccount(emailId, password);
            userDetail();
            groundDetail();
            amenitiesDetail();
            //timingDetail();
        } else {
            Log.d("Registraion ", " Incomplete");
            //Toast.makeText(Registration.this, "Not REGISTER", Toast.LENGTH_SHORT).show();
        }

    }

    private void amenitiesDetail() {
        AmenitiesDetail ground = new AmenitiesDetail(washroom, equipmentRental, sittingArea, drinkingWater, parking, changingRoom, mKey);
        mDatabase.child(getResources().getString(R.string.amenities_list_id)).push().setValue(ground);
    }

    private void groundDetail() {

        //GroundInfo(String groundName, String openingTime, String closingTime, double price, String groundType, String address)
        GroundInfo ground = new GroundInfo(groundName, openingHour, openingMinute, closingHour, closingMinute, price, "Football", address, mKey);
        mDatabase.child(getResources().getString(R.string.ground_list_id)).push().setValue(ground);
    }

    private void userDetail() {
        mKey = mDatabase.child(getResources().getString(R.string.manager_list_id)).push().getKey();
        ManagerDetail user = new ManagerDetail(firstName, lastName, emailId, phonenumber, groundName, mKey);
        mDatabase.child(getResources().getString(R.string.manager_list_id)).push().setValue(user);
    }

    private void createAccount(String email, String password) {
        Log.d("Registration ", "createAccount:" + email);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("SAD", "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(Registration.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        startActivity(new Intent(Registration.this, AdminHome.class));
                    }
                });
    }

    private boolean validate() {
        boolean firstName, lastName, emailId, groundName, openingTime, closingTime, address, phonenumber, price, agreement, password;

        if (isEmpty(mFirstName)) {
            firstName = false;
        } else {
            firstName = true;
        }
        if (isEmpty(mLastName)) {
            lastName = false;
        } else {
            lastName = true;
        }
        if (isEmpty(mEmail)) {
            emailId = false;
        } else {
            emailId = true;
        }
        if (isEmpty(mPassword)) {
            password = false;
        } else {
            if (isValidPassword(mPassword)) {
                password = true;
            } else {
                mPassword.setError("Minimum 8 characters required");
                password = false;
            }
        }
        if (isEmpty(mGroundName)) {
            groundName = false;
        } else {
            groundName = true;
        }
        if (isEmpty(mOpeningTime)) {
            openingTime = false;
        } else {
            openingTime = true;
        }
        if (isEmpty(mClosingTime)) {
            closingTime = false;
        } else {
            closingTime = true;
        }
        if (isEmpty(mAddress)) {
            address = false;
        } else {
            address = true;
        }
        if (isEmpty(mPhoneNumber)) {
            phonenumber = false;
        } else {
            phonenumber = true;
        }
        if (isEmpty(mPrice)) {
            price = false;
        } else {
            price = true;
        }
        if (mAgreement.isChecked()) {
            agreement = true;
        } else {
            agreement = false;
            Toast.makeText(Registration.this, "Please select I agree", Toast.LENGTH_SHORT).show();
        }


        if (firstName && lastName && emailId && phonenumber && groundName && price && openingTime && closingTime && address && agreement && password) {
            //Toast.makeText(Registration.this, "COMPLETE", Toast.LENGTH_SHORT).show();
            Log.d("Validation ", " Complete");
            return true;
        } else {
            //Toast.makeText(Registration.this, "INCOMPLETE", Toast.LENGTH_SHORT).show();
            Log.d("Validation ", " Incomplete");
            return false;
        }
    }

    private boolean isValidPassword(EditText mPassword) {
        return mPassword.getText().toString().trim().length() >= 8;
    }

    private boolean isEmpty(EditText myeditText) {
        boolean empty = myeditText.getText().toString().trim().length() == 0;
        if (empty) {
            myeditText.setError("Enter Field");
        }
        return empty;
    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}
