package com.am.a3dpernikguide.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.am.a3dpernikguide.model.db.FindsEntry;
import com.am.a3dpernikguide.model.db.ModelEntry;

import java.util.List;

/**
 * @author Created by Aleks Vasilev Milchov
 *
 * ModelDao is interface that contains different request to the local database
 */
@Dao
public interface ModelDao {

    //MODELS ENTRY
    @Query("SELECT * FROM models WHERE code = :code")
    ModelEntry getModel(String code);

    @Query("SELECT * FROM models ORDER BY id LIMIT 1")
    ModelEntry loadModel();

    @Query("DELETE FROM models")
    void deleteModel();

    @Query("SELECT * FROM models WHERE is_visited = 1 AND user_token = :userToken")
    List<ModelEntry> loadModels(String userToken);

    @Query("UPDATE models SET is_visited=1, user_token = :userToken WHERE code = :code")
    void updateModelVisited(String code, String userToken);

    @Insert
    void insertModel(ModelEntry... modelEntries);

    @Insert
    void insertModels(List<ModelEntry> modelEntries);

    //FINDS ENTRY
    @Query("SELECT * FROM finds ORDER BY id LIMIT 1")
    FindsEntry loadFind();

    @Query("SELECT * FROM finds")
    List<FindsEntry> loadFinds();

    @Insert
    void insertFinds(List<FindsEntry> findsEntries);

    @Insert
    void insertFind(FindsEntry... findsEntries);
}
