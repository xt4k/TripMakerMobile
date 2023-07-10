package tripmaker.model;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class UserProfile {

    private  String firstName;
    private  String lastName;
    private  String email;

}
