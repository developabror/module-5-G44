
package uz.app;


import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Times {

    private String asr;
    private String hufton;
    private String peshin;
    private String quyosh;
    @SerializedName("shom_iftor")
    private String shomIftor;
    @SerializedName("tong_saharlik")
    private String tongSaharlik;

}
