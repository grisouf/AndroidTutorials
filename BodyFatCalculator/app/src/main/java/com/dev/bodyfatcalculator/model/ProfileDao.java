package com.dev.bodyfatcalculator.model;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProfileDao {

    /**
     * Insert Command
     * @param profile object that will be inserted
     */
    @Insert
    void insert(Profile profile);

    /**
     * Update Command
     * @param profile object that will be updated
     */
    @Update
    void update(Profile profile);

    /**
     * Delete Command
     * @param profile object that will be deleted
     */
    @Delete
    void delete(Profile profile);


    /**
     * Select command for selecting all Rows
     * @return Live date of List
     */
    @Query("SELECT * FROM tb_profile")
    LiveData<List<Profile>> selectAll();

    /**
     * select specific Object from Database
     * @param id object id
     * @return live data of the object
     */
    @Query("SELECT * FROM tb_profile WHERE id LIKE :id")
    LiveData<Profile> selectProfile(int id);

}
