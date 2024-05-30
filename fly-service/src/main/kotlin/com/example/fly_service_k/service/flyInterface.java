package com.example.destiny_service.services;



import com.example.destiny_service.model.entities.Destiny;

import java.util.List;

public interface flyInterface {
    public List<Fly> getAllFlys();
    public Destiny addFly(flyRequest: FlyRequest);
    public Destiny updateFly(flyRequest: FlyRequest);
}
