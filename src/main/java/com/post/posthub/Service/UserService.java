package com.post.posthub.Service;

import com.post.posthub.Entity.User;
import com.post.posthub.exception.InvalidCredentialsException;
import com.post.posthub.exception.UserAlreadyExistsException;
import com.post.posthub.exception.UserNotFoundException;

public interface UserService {
    User signUp(String username, String email, String password) throws UserAlreadyExistsException;

    public User login(String username, String password) throws InvalidCredentialsException, UserNotFoundException;
}
