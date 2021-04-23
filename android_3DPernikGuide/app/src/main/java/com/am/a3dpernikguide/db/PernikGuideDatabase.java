package com.am.a3dpernikguide.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.am.a3dpernikguide.model.db.FindsEntry;
import com.am.a3dpernikguide.model.db.ModelEntry;

/**
 * @author Created by Aleks Vasilev Milchov
 *
 * This class created the local database
 */
@Database(entities = {ModelEntry.class, FindsEntry.class}, version = 5)
public abstract class PernikGuideDatabase extends RoomDatabase {
    private static PernikGuideDatabase INSTANCE;

    public abstract ModelDao modelDao();

    //get database with design pattern - singleton
    public static PernikGuideDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            // allowMainThreadQueries should not be used, it is added so the query can be executed in
            // the main thread, now we know that it is quick enough and works for now, but should be refactored!!!
            INSTANCE = Room.databaseBuilder(context, PernikGuideDatabase.class, "pernikguide_db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    //this method destroy the instance of the database
    public static void destroyInstance() {
        INSTANCE = null;
    }
}
