package services.MembersService;

import Entities.Member;
import java.util.ArrayList;

public interface MemberService {
    void registerMember(int id , String name , String  email );
    void removeMember(int id  );
    Member searchMember(int id  );
    void displayAllMembers();
}
