package com.am.a3dpernikguide.model.api.finds;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Created by Aleks Vasilev Milchov
 */

public class FindsData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("find_id")
    @Expose
    private Integer findId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("find")
    @Expose
    private Find find;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFindId() {
        return findId;
    }

    public void setFindId(Integer findId) {
        this.findId = findId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Find getFind() {
        return find;
    }

    public void setFind(Find find) {
        this.find = find;
    }

}