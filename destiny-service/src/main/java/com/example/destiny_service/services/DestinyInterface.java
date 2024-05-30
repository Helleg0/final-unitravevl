package com.example.destiny_service.services;



import com.example.destiny_service.model.entities.Destiny;

import java.util.List;

public interface DestinyInterface {
    public List<Destiny> getAllBooks();
    public Destiny addDestiny(Destiny destiny);
    public Destiny updateDestiny(int id, Destiny destiny);
}
