package pl.arkadiusz.SpringAndSwagger.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.arkadiusz.SpringAndSwagger.model.Address;
import pl.arkadiusz.SpringAndSwagger.model.Facture;

import java.util.List;

@Getter
@Setter
@Builder
public class UserDto {

    private long id;

    private String name;
    private String lastname;
    private String username;
    private String password;
    private boolean enabled;

    private Address address;
    private List<Facture> factures;

}
