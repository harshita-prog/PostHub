package com.post.posthub.Service;

import com.post.posthub.Entity.User;
import com.post.posthub.exception.UserAlreadyExistsException;

public interface UserService {
    User signUp(String username, String email, String password) throws UserAlreadyExistsException;
}

