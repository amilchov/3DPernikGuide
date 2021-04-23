package com.am.a3dpernikguide.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author Created by Aleks Vasilev Milchov
 */
@Entity(tableName = "models")
public class ModelEntry {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "code")
    private String code;

    @ColumnInfo(name = "path")
    private String path;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "is_visited")
    private boolean isVisited;

    @ColumnInfo(name = "image_path")
    private String imagePath;

    @ColumnInfo(name = "user_token", defaultValue = "")
    private String userToken;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public ModelEntry(String title, String description, String code, String path, String type, boolean isVisited, String imagePath) {
        this.title = title;
        this.description = description;
        this.code = code;
        this.path = path;
        this.type = type;
        this.isVisited = isVisited;
        this.imagePath = imagePath;
    }
}
