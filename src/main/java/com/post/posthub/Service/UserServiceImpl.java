package com.post.posthub.Service;

import com.post.posthub.Entity.User;
import com.post.posthub.Repository.UserRepository;
import com.post.posthub.exception.InvalidCredentialsException;
import com.post.posthub.exception.UserAlreadyExistsException;
import com.post.posthub.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public User signUp(String username, String email, String password) throws UserAlreadyExistsException {
        // Check if the user already exists
        if (userRepository.findByUsername(username).isPresent()) {
            throw new UserAlreadyExistsException("Username already exists");
        }
        if (userRepository.findByEmail(email) != null) {
            throw new UserAlreadyExistsException("Email already exists");
        }

        // Create a new user account
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword((password));

        return userRepository.save(user);
    }

    public User login(String username, String password) throws InvalidCredentialsException, UserNotFoundException {
        User user =
                userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found."));
        if (!user.getPassword().equals(password)) {
            throw new InvalidCredentialsException("Invalid credentials.");
        }
        return user;
    }
}
