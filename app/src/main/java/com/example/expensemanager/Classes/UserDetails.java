package com.example.expensemanager.Classes;

import android.os.Parcel;
import android.os.Parcelable;

public class UserDetails implements Parcelable {
    private String name;
    private String email;
    private String Contact;

    public UserDetails(String name, String email, String contact) {
        this.name = name;
        this.email = email;
        Contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public static Creator<UserDetails> getCREATOR() {
        return CREATOR;
    }

    protected UserDetails(Parcel in) {
        name = in.readString();
        email = in.readString();
        Contact = in.readString();
    }

    public static final Creator<UserDetails> CREATOR = new Creator<UserDetails>() {
        @Override
        public UserDetails createFromParcel(Parcel in) {
            return new UserDetails(in);
        }

        @Override
        public UserDetails[] newArray(int size) {
            return new UserDetails[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(email);
        parcel.writeString(Contact);
    }
}
