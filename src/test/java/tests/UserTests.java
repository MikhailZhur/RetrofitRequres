package tests;

import endpoints.UserService;
import models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

        Response<UserListRootResponse> response = userService.getUserList(apiKey, page).execute();
        Assertions.assertTrue(response.isSuccessful());

        UserListRootResponse rootResponse = response.body();
        assert rootResponse != null;
        assertEquals(page,rootResponse.getPage());

        List<UserResponse> userData = rootResponse.getData();
        assertFalse(userData.isEmpty());

    }

    @Test
    public void testSingleUserPage() throws IOException {
        int id = 3;
        String apiKey = "reqres-free-v1";

        Response<SingleUserResponse> response = userService.getUserById(apiKey, id).execute();
        assertTrue(response.isSuccessful());
        SingleUserResponse userResponse = response.body();
        assertEquals(id, userResponse.getData().getId());
    }

    @Test
    public void testCreateUser() throws IOException {
        String apiKey = "reqres-free-v1";
        String correctTimePattern = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{3}Z";
        String name = "Misha";
        String job = "AQA";
        UserRequest userRequest = new UserRequest(name,job);

        Response<CreateUserResponse> response = userService.createUser(apiKey,userRequest).execute();
        assertTrue(response.isSuccessful());
        CreateUserResponse userResponse = response.body();
        assertEquals(name, userResponse.getName());
        assertEquals(job, userResponse.getJob());
        assertTrue(userResponse.getCreatedAt().matches(correctTimePattern));
    }

}
