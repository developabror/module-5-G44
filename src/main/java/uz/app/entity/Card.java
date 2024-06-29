package uz.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class Card /*implements Comparable<Card>*/{

    private String number;
    private String expireDate;
    private Double balance;


    public int compareTo(Card o) {
        return 0;
    }
}
