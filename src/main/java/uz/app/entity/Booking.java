package uz.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.app.entity.enums.Status;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private final String id = UUID.randomUUID().toString();
    private String userId;
    private Integer floor;
    private Integer room;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Boolean active;
    private Status status;
}
