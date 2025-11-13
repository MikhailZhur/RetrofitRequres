package tests;

import endpoints.UserService;
import models.UserListRootResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class UserTests {
    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private final UserService userService = retrofit.create(UserService.class);

    @Test
    public void testUserListPage() throws IOException {
        int page = 1;
        String apiKey = "reqres-free-v1";

        Response<UserListRootResponse> response = userService.getUserList(page,apiKey).execute();
        Assertions.assertTrue(response.isSuccessful());

    }
}
