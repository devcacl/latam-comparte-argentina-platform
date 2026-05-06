package com.org.argentinacompartepage.models.daos;

import com.org.argentinacompartepage.entities.UserEntity;
import com.org.argentinacompartepage.entities.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    List<UserEntity> findByNombreContainingIgnoreCase(String nombre);

    List<UserEntity> findByRol(RoleName rol);

    List<UserEntity> findByActivoTrue();

    @Query("""
            SELECT u FROM UserEntity u
            WHERE (:nombre IS NULL OR :nombre = '' OR
            LOWER(u.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')))
            AND (:email IS NULL OR :email = '' OR
            LOWER(u.email) LIKE LOWER(CONCAT('%', :email, '%')))
            AND (:rol IS NULL OR u.rol = :rol)
            AND (:activo IS NULL OR u.activo = :activo)
            AND (:id IS NULL OR u.id = :id)
            """)
    List<UserEntity> filterUsers(
            @Param("nombre") String nombre,
            @Param("email") String email,
            @Param("rol") RoleName rol,
            @Param("activo") Boolean activo,
            @Param("id") Long id
    );
}
