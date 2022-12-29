package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name;
    private String email;
    private String title;
    private String birth_day;
    private String birth_month;
    private String birth_year;
    private String first_name;
    private String last_name;
    private String company;
    private String address1;
    private String address2;
    private String country;
    private String state;
    private String city;
    private String zipcode;


    /*
    {
   "responseCode": 200,
   "user": {
      "id": 33753,
      "name": "Automation",
      "email": "automation01@gmail.com",
      "title": "Mr",
      "birth_day": "21",
      "birth_month": "2",
      "birth_year": "1993",
      "first_name": "Automation",
      "last_name": "Exercise",
      "company": "Freelancer",
      "address1": "New york Mahallesi Zimbabwe",
      "address2": "Zimbabwe Uganda Cumhuriyeti",
      "country": "Australia",
      "state": "Podoso",
      "city": "Usak",
      "zipcode": "6590902"
   }
     */


}
