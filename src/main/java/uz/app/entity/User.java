package uz.app.entity;


import lombok.*;

//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Data
//@Setter
//@Getter
//@ToString
//@EqualsAndHashCode(of = {"username", "age"})

public class User {
    @NonNull
    private String username;
    @NonNull
    private String password;
    private String age;
    private String birthDate;

}
