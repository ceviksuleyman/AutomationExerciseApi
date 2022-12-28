package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    private int id;
    private String name;
    private String price;
    private String brand;
    private Category category;
}
