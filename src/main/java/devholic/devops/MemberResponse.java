package devholic.devops;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberResponse {

    private Long id;
    private String name;

    public static MemberResponse from(Long id, String name) {
        return new MemberResponse(id, name);
    }

    private MemberResponse (Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
