package pl.arkadiusz.SpringAndSwagger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.arkadiusz.SpringAndSwagger.dto.UserDto;
import pl.arkadiusz.SpringAndSwagger.dto.UserDtoMapper;
import pl.arkadiusz.SpringAndSwagger.dto.UserInsert;
import pl.arkadiusz.SpringAndSwagger.model.Address;
import pl.arkadiusz.SpringAndSwagger.model.Facture;
import pl.arkadiusz.SpringAndSwagger.model.User;
import pl.arkadiusz.SpringAndSwagger.service.AddressService;
import pl.arkadiusz.SpringAndSwagger.service.FactureService;
import pl.arkadiusz.SpringAndSwagger.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    @Autowired
    private final UserService userService;
    @Autowired
    private final FactureService factureService;
    @Autowired
    private final AddressService addressService;



    @GetMapping("/getAllUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @GetMapping("/getAllUsersDTO")
    public List<UserDto> getUsersDTO() {
        return UserDtoMapper.mapToUserDtos(userService.getUsers());
    }

    @GetMapping("/getAllFactures")
    public List<Facture> getFactures() {
        return factureService.getFactures();
    }

    @GetMapping("/getFacturesAbove")
    public List<Facture> getFacturesAbove(@RequestParam double total) {
        return factureService.findAbove(total);
    }


    @GetMapping("/getUsers&Factures")
    public List<UserDto> getUaF() {
        return userService.getUaF();
    }

    @GetMapping("/getUsers&Address")
    public List<UserDto> getUaA() {
        return userService.getUaA();
    }



    @PostMapping("/addUserWithAddress")
    public void addUserAddress(@RequestBody UserInsert user) {
        userService.addUserAddress(user);
    }


    @PostMapping("/addAddress")
    public Address addAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @PostMapping("/addFacture")
    public Facture addFacture(@RequestBody Facture facture) {
        return factureService.addFacture(facture);
    }


    @PutMapping("/editFacture")
    public void editFacture(@RequestBody Facture facture) {
        factureService.editFacture(facture);
    }

    @PutMapping("/editUser")
    public void editUser(@RequestBody User user) {
        userService.editUser(user);
    }

    @PutMapping("/editAddress")
    public void editAddress(@RequestBody Address address ) {
        addressService.editAddress(address);
    }

    
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @DeleteMapping("/deleteFacture/{id}")
    public void deleteFacture(@PathVariable long id) {
        factureService.deleteFacture(id);
    }

}
