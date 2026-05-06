package com.org.argentinacompartepage.models.services;

import com.org.argentinacompartepage.entities.UserEntity;
import com.org.argentinacompartepage.entities.enums.RoleName;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> ListAll();

    UserEntity findById(Long id);

    Optional<UserEntity> findByEmail(String email);

    void save(UserEntity user);

    void delete(Long id);

    List<UserEntity> searchByName(String nombre);

    List<UserEntity> filterUsers(String nombre, String email, RoleName rol, Boolean activo, Long id);
}
