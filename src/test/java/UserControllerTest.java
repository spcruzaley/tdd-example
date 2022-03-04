import com.tdd.example.controller.UserController;
import com.tdd.example.model.Gender;
import com.tdd.example.model.User;
import com.tdd.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    UserService userService;

    @Test
    public void testGetUsers() {
        //Given (Dado)
        int elements = 5;
        List<User> expectedUsersList = createUsersDummy(elements);
        UserController userController = new UserController(userService);

        //When (Cuando)
        when(userService.getUsers()).thenReturn(expectedUsersList);
        List<User> actualUsersList = userController.getUsers();

        //Then (Entonces)
        assertNotNull(actualUsersList);
        assertEquals(actualUsersList.size(), elements);
        assertArrayEquals(expectedUsersList.toArray(), actualUsersList.toArray());
    }

    private List<User> createUsersDummy(int element) {
        return IntStream.range(0, element)
                .mapToObj(x -> createUserDummy(x+1))
                .collect(Collectors.toList());
    }

    private User createUserDummy(int id) {
        User user = new User();
        user.setId(id);
        user.setName("SPCruzaley");
        user.setGender(Gender.male);

        return user;
    }

}
