package com.example.andreza.harvardmuseums.model.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.andreza.harvardmuseums.pojo.ArtworkRoom;

import java.util.List;

@Dao
public interface ArtworkRoomDao {
    @Query("SELECT * FROM ArtworkRoom ORDER BY title ASC")
    LiveData<List<ArtworkRoom>> getAll();

    @Query("SELECT * FROM ArtworkRoom WHERE id IN (:artworkIds)")
    LiveData<List<ArtworkRoom>> loadAllByIds(int[] artworkIds);


    @Insert
    void insertAll(ArtworkRoom... artworkRooms);

    @Delete
    void delete(ArtworkRoom artworkRoom);
}