package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reqres {

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private DataReqres data;
    private SupportReqres support;


}
