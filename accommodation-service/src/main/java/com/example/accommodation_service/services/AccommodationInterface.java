package com.example.accommodation_service.services;

import com.example.accommodation_service.model.entieties.Accommodation;

import java.util.List;

public interface AccommodationInterface {
    public List<Accommodation> getAllAccommodations();
    public Accommodation addAccommodation(Accommodation accommodation);
    public Accommodation updateAccommodation(int id, Accommodation accommodation);
}
