package endpoints;

import models.UserListRootResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface UserService {
    // получение списка пользователей
    @GET("api/users") //
    Call<UserListRootResponse> getUserList(@Query("page") int pageParam, @Header("x-api-key") String apiKeyParam); //: reqres-free-v1
}
