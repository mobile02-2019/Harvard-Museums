package com.example.andreza.harvardmuseums.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.example.andreza.harvardmuseums.model.dao.ArtworkRoomDao;
import com.example.andreza.harvardmuseums.pojo.ArtworkRoom;

@Database(entities = {ArtworkRoom.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ArtworkRoomDao artworkRoomDao();
}