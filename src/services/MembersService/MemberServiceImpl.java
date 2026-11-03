package services.MembersService;

import Entities.Library;
import Entities.Member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class MemberServiceImpl implements MemberService{
    private   Library library ;

   public MemberServiceImpl( Library library){
       this.library=library;

   }

    @Override
    public void registerMember(int id, String name, String email) {
        Member  member=new Member(id,name,email);
      boolean isExistMember=  library.getMembers().stream().anyMatch(librarymember-> librarymember.getId()==id);
      if(!isExistMember){
          library.getMembers().add(member);
          System.out.print("Member added Successfully ....");
      }
      else{
          System.out.print("Member  is already Exist  ....");

      }
    }

    @Override
    public void removeMember(int id) {
        boolean isExistMember=  library.getMembers().stream().anyMatch(librarymember-> librarymember.getId()==id);

        if (isExistMember){
            Iterator<Member> memberIterator=library.getMembers().iterator();
            while (memberIterator.hasNext()) {
                Member member =memberIterator.next();
                if(member.getId()==id){
                    memberIterator.remove();
                    System.out.println("Member Removed Successfully.\n");
                    break;
                }
            }
        }
        else {
            System.out.println("Member Not Found.\n");
        }
    }

    @Override
    public Member searchMember(int id) {
        Optional<Member>memberSearch=library.getMembers().stream().filter(member->member.getId()==id).findFirst();
        return memberSearch.orElse(null);
    }

    @Override
    public void displayAllMembers() {

        if (!library.getMembers().isEmpty()){
            library.getMembers().stream().forEach(System.out::println);
        }
        else{
            System.out.print("Not Found Eny Members");
        }
    }
}
