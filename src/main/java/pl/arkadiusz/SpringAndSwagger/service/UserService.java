package pl.arkadiusz.SpringAndSwagger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.arkadiusz.SpringAndSwagger.dto.UserDto;
import pl.arkadiusz.SpringAndSwagger.dto.UserDtoMapper;
import pl.arkadiusz.SpringAndSwagger.dto.UserInsert;
import pl.arkadiusz.SpringAndSwagger.model.Address;
import pl.arkadiusz.SpringAndSwagger.model.Facture;
import pl.arkadiusz.SpringAndSwagger.model.User;
import pl.arkadiusz.SpringAndSwagger.repository.FactureRepository;
import pl.arkadiusz.SpringAndSwagger.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final FactureRepository factureRepository;

    @Autowired
    private final AddressService addressService;
    @Autowired
    private final FactureService factureService;

    public User getUser(long id) {
        return userRepository.findById(id);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }


    public List<UserDto> getUaF() {
        List<UserDto> allUsers = UserDtoMapper.mapToUserDtos(getUsers());
        List<Facture> factures = factureRepository.findAll();
        allUsers.forEach(user -> user.setFactures(extractFacture(factures, user.getId())));

        return allUsers;
    }

    private List<Facture> extractFacture(List<Facture> factures, long id) {
        return factures.stream()
                .filter(f->f.getUserid() == id)
                .collect(Collectors.toList());
    }

    public List<UserDto> getUaA() {

        return UserDtoMapper.mapToUserDtosWithAddress(getUsers());
    }



    public void addUserAddress(UserInsert userInsert) {
        Address address = Address.builder()
                .country(userInsert.getCountry())
                .province(userInsert.getProvince())
                .city(userInsert.getCity())
                .street(userInsert.getStreet())
                .house_no(userInsert.getHouse_no())
                .flat_no(userInsert.getFlat_no())
                .build();
        long addressId = addressService.addAddress(address).getId();

        User user = User.builder()
                .name(userInsert.getName())
                .lastname(userInsert.getLastname())
                .username(userInsert.getUsername())
                .password(userInsert.getPassword())
                .enabled(userInsert.isEnabled())
                .address(addressService.getById(addressId))
                .build();

        userRepository.save(user);
    }

    public void editUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
