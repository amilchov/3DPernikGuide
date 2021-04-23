package com.am.a3dpernikguide.retrofit;

import static com.am.a3dpernikguide.util.manager.DataManager.BASE_URL;

public class ApiUtils{

    public static ApiService getService() {
        return ApiClient.getClient(BASE_URL).create(ApiService.class);
    }
}