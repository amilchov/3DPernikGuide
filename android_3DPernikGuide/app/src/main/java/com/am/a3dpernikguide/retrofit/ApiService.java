package com.am.a3dpernikguide.retrofit;

import com.am.a3dpernikguide.model.api.User;
import com.am.a3dpernikguide.model.api.finds.Finds;
import com.am.a3dpernikguide.model.api.sights.fortress.Fortress;
import com.am.a3dpernikguide.model.api.sights.fortress.UserDataFortressVisited;
import com.am.a3dpernikguide.model.api.sights.museum.Museum;
import com.am.a3dpernikguide.model.api.sights.museum.UserDataMuseumVisited;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

import static com.am.a3dpernikguide.util.manager.DataManager.LOGIN;
import static com.am.a3dpernikguide.util.manager.DataManager.REGISTER;

public interface ApiService {
    @FormUrlEncoded
    @POST(REGISTER)
    Observable<Response<ResponseBody>>
    createUser(@Field("first_name") String firstName,
               @Field("middle_name") String middleName,
               @Field("last_name") String lastName,
               @Field("email") String email,
               @Field("password") String password);

    @FormUrlEncoded
    @POST(LOGIN)
    Observable<Response<User>>
    loginUser(@Field("email") String email,
              @Field("password") String password);

    @GET("data/fortress/user")
    Observable<Response<UserDataFortressVisited>>
    userDataFortress(@Header("Authorization") String authorization);

    @GET("data/museum/user")
    Observable<Response<UserDataMuseumVisited>>
    userDataMuseum(@Header("Authorization") String authorization);

    @GET("data/museum/users")
    Observable<Response<Museum>>
    aggregatedDataMuseum();

    @GET("data/fortress/users")
    Observable<Response<Fortress>>
    aggregatedDataFortress();

    @FormUrlEncoded
    @PUT("data/fortress/user/update")
    Observable<Response<ResponseBody>>
    updateFortressData(@Header("Authorization") String authorization,
                       @Field("count_fortress") String countFortress,
                       @Field("last_visit_fortress") String lastVisitFortress,
                       @Field("date") String date);

    @FormUrlEncoded
    @PUT("data/museum/user/update")
    Observable<Response<ResponseBody>>
    updateMuseumData(@Header("Authorization") String authorization,
                     @Field("count_museum") String countFortress,
                     @Field("last_visit_museum") String lastVisitFortress,
                     @Field("date") String date);

    @GET("user/finds")
    Observable<Response<Finds>>
    loadFindsData(@Header("Authorization") String authorization);


}
