package com.org.argentinacompartepage.models.services;

import com.org.argentinacompartepage.entities.ContactRequestEntity;
import com.org.argentinacompartepage.entities.enums.ContactPurpose;

import java.util.List;

public interface ContactRequestService {
    List<ContactRequestEntity> ListAll();

    ContactRequestEntity findById(Long id);

    void save(ContactRequestEntity contactRequest);

    void delete(Long id);

    List<ContactRequestEntity> searchByName(String nombre);

    List<ContactRequestEntity> listUnread();

    List<ContactRequestEntity> listPending();

    List<ContactRequestEntity> filterContactRequests(
            String nombre,
            String correo,
            ContactPurpose finalidad,
            Boolean leido,
            Boolean atendido,
            Long id
    );
}
