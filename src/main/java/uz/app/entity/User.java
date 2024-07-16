package uz.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
 @AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private final String id = UUID.randomUUID().toString();
    private String name;
    private String email;
    private String password;
    private String role;

}
