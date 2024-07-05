package cl.praxis.firstprojectdao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private int userId;
    private String name;
    private String lastName;
    private String email;
    private int age;
    private int isActive;

    public UserDTO(String name, String lastName, String email, int age, int isActive) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.isActive = isActive;
    }
}
