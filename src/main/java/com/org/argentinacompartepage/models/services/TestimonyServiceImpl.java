package com.org.argentinacompartepage.models.services;

import com.org.argentinacompartepage.entities.TestimonyEntity;
import com.org.argentinacompartepage.models.daos.TestimonyDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestimonyServiceImpl implements TestimonyService {

    private final TestimonyDao testimonyDao;

    public TestimonyServiceImpl(TestimonyDao testimonyDao) {
        this.testimonyDao = testimonyDao;
    }

    @Override
    public List<TestimonyEntity> ListAll() {
        return testimonyDao.findAll();
    }

    @Override
    public TestimonyEntity findById(Long id) {
        return testimonyDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Testimonio no encontrado"));
    }

    @Override
    public void save(TestimonyEntity testimony) {
        testimonyDao.save(testimony);
    }

    @Override
    public void delete(Long id) {
        testimonyDao.deleteById(id);
    }

    @Override
    public List<TestimonyEntity> searchByName(String nombre) {
        return testimonyDao.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<TestimonyEntity> listActiveOrdered() {
        return testimonyDao.findByActivoTrueOrderByOrdenAscFechaCreacionDesc();
    }

    @Override
    public List<TestimonyEntity> listFeaturedActive() {
        return testimonyDao.findByDestacadoTrueAndActivoTrueOrderByOrdenAscFechaCreacionDesc();
    }

    @Override
    public List<TestimonyEntity> filterTestimonies(String nombre, Boolean activo, Boolean destacado, Long id) {
        return testimonyDao.filterTestimonies(nombre, activo, destacado, id);
    }
}
