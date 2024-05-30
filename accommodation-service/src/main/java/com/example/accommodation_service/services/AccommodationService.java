package com.example.accommodation_service.services;

import com.example.accommodation_service.model.dtos.AccommodationRequest;
import com.example.accommodation_service.model.dtos.AccommodationResponse;
import com.example.accommodation_service.model.entieties.Accommodation;
import com.example.accommodation_service.repositories.AccommodationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccommodationService {
    private final AccommodationRepository accommodationRepository;
    public void addAccommodation(AccommodationRequest accommodationRequest){
        var accommodation = Accommodation.builder()
                .id(accommodationRequest.getId())
                .name(accommodationRequest.getName())
                .location(accommodationRequest.getLocation())
                .characteristics(accommodationRequest.getCharacteristics())
                .maxCapacity(accommodationRequest.getMaxCapacity())
                .price(accommodationRequest.getPrice())
                .status(accommodationRequest.isStatus())
                .build();

        accommodationRepository.save(accommodation);

        log.info("Accommodation added: {}",accommodation);
    }

    public List<AccommodationResponse> getAllAccommodations(){
        var accommodations = accommodationRepository.findAll();

        return accommodations.stream().map(this::mapToAccommodationResponse).toList();
    }

    private AccommodationResponse mapToAccommodationResponse(Accommodation accommodation){
        return AccommodationResponse.builder()
                .id(accommodation.getId())
                .name(accommodation.getName())
                .location(accommodation.getLocation())
                .characteristics(accommodation.getCharacteristics())
                .maxCapacity(accommodation.getMaxCapacity())
                .price(accommodation.getPrice())
                .build();
    }

    public void updateAccommodation(AccommodationRequest accommodationRequest){
        Optional<Accommodation> optionalAccommodation = accommodationRepository.findById(accommodationRequest.getId());
        if(optionalAccommodation.isPresent()){
            Accommodation accommodation = optionalAccommodation.get();

            accommodation.setName(accommodationRequest.getName());
            accommodation.setLocation(accommodationRequest.getLocation());
            accommodation.setCharacteristics(accommodationRequest.getCharacteristics());
            accommodation.setMaxCapacity(accommodationRequest.getMaxCapacity());
            accommodation.setPrice(accommodationRequest.getPrice());

            accommodationRepository.save(accommodation);
            log.info("accommodation updated: {}",accommodation);
        }else{
            log.error("accommodation with ID {} not found",accommodationRequest.getId());
        }
    }

    public void deleteAccommodation(Long accommodationID){
        Optional<Accommodation> optionalAccommodation = accommodationRepository.findById(accommodationID);
    }
}
