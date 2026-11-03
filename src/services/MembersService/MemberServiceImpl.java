
package services.MembersService;

import Entities.Library;
import Entities.Member;

import java.util.Iterator;
import java.util.Optional;

/**
 * Implements the member management operations defined in MemberService.
 * Uses a shared Library instance to manage registered members.
 */
public class MemberServiceImpl implements MemberService {

    private Library library;

    /**
     * Constructs the member service using a shared library instance.
     *
     * @param library the library whose members will be managed
     */
    public MemberServiceImpl(Library library) {
        this.library = library;
    }

    /**
     * Registers a new member if their ID does not already exist.
     *
     * @param id    the unique identifier of the member
     * @param name  the member's name
     * @param email the member's email address
     */
    @Override
    public void registerMember(int id, String name, String email) {

        Member member = new Member(id, name, email);

        boolean isExistMember = library.getMembers().stream()
                .anyMatch(librarymember -> librarymember.getId() == id);

        if (!isExistMember) {
            library.getMembers().add(member);
            System.out.print("Member added Successfully ....");
        } else {
            System.out.print("Member is already Exist ....");
        }
    }

    /**
     * Removes a registered member using their ID.
     *
     * @param id the ID of the member to remove
     */
    @Override
    public void removeMember(int id) {

        boolean isExistMember = library.getMembers().stream()
                .anyMatch(librarymember -> librarymember.getId() == id);

        if (isExistMember) {
            Iterator<Member> memberIterator = library.getMembers().iterator();

            while (memberIterator.hasNext()) {
                Member member = memberIterator.next();

                if (member.getId() == id) {
                    memberIterator.remove();
                    System.out.println("Member Removed Successfully.\n");
                    break;
                }
            }
        } else {
            System.out.println("Member Not Found.\n");
        }
    }

    /**
     * Searches for a member using their ID.
     *
     * @param id the ID of the member to search for
     * @return the matching member, or null if no member is found
     */
    @Override
    public Member searchMember(int id) {

        Optional<Member> memberSearch = library.getMembers().stream()
                .filter(member -> member.getId() == id)
                .findFirst();

        return memberSearch.orElse(null);
    }

    /**
     * Displays all registered members.
     * Prints a message if no members are registered.
     */
    @Override
    public void displayAllMembers() {

        if (!library.getMembers().isEmpty()) {
            library.getMembers().stream()
                    .forEach(System.out::println);
        } else {
            System.out.print("Not Found Any Members");
        }
    }
}
