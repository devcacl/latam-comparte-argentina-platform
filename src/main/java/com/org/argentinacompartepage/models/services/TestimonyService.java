package com.org.argentinacompartepage.models.services;

import com.org.argentinacompartepage.entities.TestimonyEntity;

import java.util.List;

public interface TestimonyService {
    List<TestimonyEntity> ListAll();

    TestimonyEntity findById(Long id);

    void save(TestimonyEntity testimony);

    void delete(Long id);

    List<TestimonyEntity> searchByName(String nombre);

    List<TestimonyEntity> listActiveOrdered();

    List<TestimonyEntity> listFeaturedActive();

    List<TestimonyEntity> filterTestimonies(String nombre, Boolean activo, Boolean destacado, Long id);
}
