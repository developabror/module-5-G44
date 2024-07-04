
package uz.app.currencyConverter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Currency {

    @SerializedName("Ccy")
    private String ccy;
    @SerializedName("CcyNm_EN")
    private String ccyNmEN;
    @SerializedName("CcyNm_RU")
    private String ccyNmRU;
    @SerializedName("CcyNm_UZ")
    private String ccyNmUZ;
    @SerializedName("CcyNm_UZC")
    private String ccyNmUZC;
    @SerializedName("Code")
    private String code;
    @SerializedName("Date")
    private String date;
    @SerializedName("Diff")
    private String diff;
    @Expose
    private Long id;
    @SerializedName("Nominal")
    private String nominal;
    @SerializedName("Rate")
    private String rate;

}
