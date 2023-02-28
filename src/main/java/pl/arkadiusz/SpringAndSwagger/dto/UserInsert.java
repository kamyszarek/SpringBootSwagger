package pl.arkadiusz.SpringAndSwagger.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserInsert {

    private long id;

    private String name;
    private String lastname;
    private String username;
    private String password;
    private boolean enabled;

    private String country;
    private String province;
    private String city;
    private String street;
    private String house_no;
    private String flat_no;


}
