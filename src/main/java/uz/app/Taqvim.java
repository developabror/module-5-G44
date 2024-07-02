
package uz.app;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor@Data
public class Taqvim {
    private String date;
    @SerializedName("hijri_date")
    private HijriDate hijriDate;
    private String region;
    private Times times;
    private String weekday;
}
