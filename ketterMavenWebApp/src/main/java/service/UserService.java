package service;

import dao.UserDao;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by bramd on 6-3-2017.
 */
@Stateless
public class UserService {
    @Inject
    private UserDao userDao;

    public UserService() {
    }
}
