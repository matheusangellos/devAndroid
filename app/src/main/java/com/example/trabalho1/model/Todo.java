package com.example.trabalho1.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

public class Todo implements Parcelable {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public Todo(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    protected Todo(Parcel parcel) {
        userId = parcel.readInt();
        id = parcel.readInt();
        title = parcel.readString();
        completed = parcel.readBoolean();
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(userId);
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeBoolean(this.completed);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Todo> CREATOR = new Creator<Todo>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Todo createFromParcel(Parcel in) {
            return new Todo(in);
        }

        @Override
        public Todo[] newArray(int size) {
            return new Todo[size];
        }
    };
}
