package com.am.a3dpernikguide.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author Created by Aleks Vasilev Milchov
 */

@Entity(tableName = "finds")
public class FindsEntry {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "find_id")
    private int idFind;

    @ColumnInfo(name = "user_id")
    private int idUser;

    @ColumnInfo(name = "is_visited")
    private int isVisited;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "description")
    String description;

    @ColumnInfo(name = "image_url")
    String urlImage;

    @ColumnInfo(name = "material")
    String material;

    @ColumnInfo(name = "period")
    String period;

    @ColumnInfo(name = "latitude")
    String latitude;

    @ColumnInfo(name = "longitude")
    String longitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFind() {
        return idFind;
    }

    public void setIdFind(int idFind) {
        this.idFind = idFind;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(int isVisited) {
        this.isVisited = isVisited;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public FindsEntry(int idFind, int idUser, int isVisited, String name, String description, String urlImage, String material, String period, String latitude, String longitude) {
        this.idFind = idFind;
        this.idUser = idUser;
        this.isVisited = isVisited;
        this.name = name;
        this.description = description;
        this.urlImage = urlImage;
        this.material = material;
        this.period = period;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
