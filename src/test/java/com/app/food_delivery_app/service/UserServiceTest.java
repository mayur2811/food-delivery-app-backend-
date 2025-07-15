import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.app.model.User;
import com.app.repository.UserRepository;
import com.app.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setUserId(1);
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password");
        user.setAddress("123 Main St");
        user.setPhone("1234567890");
    }

    @Test
    public void testCreateUser() {
        when(userRepository.save(any(User.class))).thenReturn(user);
        User createdUser = userService.createUser(user);
        assertNotNull(createdUser);
        assertEquals("John Doe", createdUser.getName());
    }

    @Test
    public void testGetUserById() {
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        User foundUser = userService.getUserById(1);
        assertNotNull(foundUser);
        assertEquals("John Doe", foundUser.getName());
    }

    @Test
    public void testUpdateUser() {
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        user.setName("Jane Doe");
        when(userRepository.save(any(User.class))).thenReturn(user);
        User updatedUser = userService.updateUser(1, user);
        assertNotNull(updatedUser);
        assertEquals("Jane Doe", updatedUser.getName());
    }

    @Test
    public void testDeleteUser() {
        doNothing().when(userRepository).deleteById(1);
        userService.deleteUser(1);
        verify(userRepository, times(1)).deleteById(1);
    }
}