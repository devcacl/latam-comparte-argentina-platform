package com.org.argentinacompartepage.models.services;

import com.org.argentinacompartepage.entities.UserEntity;
import com.org.argentinacompartepage.entities.enums.RoleName;
import com.org.argentinacompartepage.models.daos.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserEntity> ListAll() {
        return userDao.findAll();
    }

    @Override
    public UserEntity findById(Long id) {
        return userDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public void save(UserEntity user) {
        userDao.save(user);
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public List<UserEntity> searchByName(String nombre) {
        return userDao.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<UserEntity> filterUsers(String nombre, String email, RoleName rol, Boolean activo, Long id) {
        return userDao.filterUsers(nombre, email, rol, activo, id);
    }
}
