package com.org.argentinacompartepage.models.services;

import com.org.argentinacompartepage.entities.ContactRequestEntity;
import com.org.argentinacompartepage.entities.enums.ContactPurpose;
import com.org.argentinacompartepage.models.daos.ContactRequestDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactRequestServiceImpl implements ContactRequestService {

    private final ContactRequestDao contactRequestDao;

    public ContactRequestServiceImpl(ContactRequestDao contactRequestDao) {
        this.contactRequestDao = contactRequestDao;
    }

    @Override
    public List<ContactRequestEntity> ListAll() {
        return contactRequestDao.findAll();
    }

    @Override
    public ContactRequestEntity findById(Long id) {
        return contactRequestDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud de contacto no encontrada"));
    }

    @Override
    public void save(ContactRequestEntity contactRequest) {
        contactRequestDao.save(contactRequest);
    }

    @Override
    public void delete(Long id) {
        contactRequestDao.deleteById(id);
    }

    @Override
    public List<ContactRequestEntity> searchByName(String nombre) {
        return contactRequestDao.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<ContactRequestEntity> listUnread() {
        return contactRequestDao.findByLeidoFalse();
    }

    @Override
    public List<ContactRequestEntity> listPending() {
        return contactRequestDao.findByAtendidoFalse();
    }

    @Override
    public List<ContactRequestEntity> filterContactRequests(
            String nombre,
            String correo,
            ContactPurpose finalidad,
            Boolean leido,
            Boolean atendido,
            Long id
    ) {
        return contactRequestDao.filterContactRequests(nombre, correo, finalidad, leido, atendido, id);
    }
}
