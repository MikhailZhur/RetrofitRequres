package endpoints;

import models.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserService {

    // получение списка пользователей
    @GET("api/users")
    Call<UserListRootResponse> getUserList(@Header("x-api-key") String apiKeyParam,
                                           @Query("page") int pageParam);

    // ѕолучение пользовател€ по id
    @GET("api/users/{id}")
    Call<SingleUserResponse> getUserById(@Header("x-api-key") String apiKeyParam,
                                         @Path("id") int id);

    // —оздание нового пользовател€
    @POST("api/users")
    Call<CreateUserResponse> createUser(@Header("x-api-key") String apiKeyParam,
                                        @Body UserRequest userRequest);
    // ќбновление пользовател€ по id
    @PUT("api/users/{id}")
    Call<UpdateUserResponse> updateUserById(@Header("x-api-key") String apiKeyParam,
                                        @Path("id") int id,
                                        @Body UserRequest userRequest);

    @DELETE("api/users/{id}")
    Call<Void> deleteUserById(@Header("x-api-key") String apiKeyParam,
                              @Path("id") int id);
}
