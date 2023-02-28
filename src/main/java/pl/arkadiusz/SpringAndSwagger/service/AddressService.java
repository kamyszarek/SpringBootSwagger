package pl.arkadiusz.SpringAndSwagger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.arkadiusz.SpringAndSwagger.model.Address;
import pl.arkadiusz.SpringAndSwagger.repository.AddressRepository;

@Service
@RequiredArgsConstructor
public class AddressService {

    @Autowired
    private final AddressRepository addressRepository;



    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address getById(long addressId) {
        return addressRepository.findById(addressId).orElseThrow();
    }


    public void editAddress(Address address) {
        addressRepository.save(address);
    }
}
