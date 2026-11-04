
package services.MembersService;

import Entities.Library;
import Entities.Member;

import java.util.Iterator;
import java.util.Optional;
import java.util.Arrays;
import java.util.Objects;

import Exeptions.MemberAlreadyExistsException;
import Exeptions.MemberNotFoundException;
import Exeptions.MemberHasBorrowedBooksException;

/**
 * Implements the member management operations defined in MemberService.
 * Uses a shared Library instance to manage registered members.
 */
public class MemberServiceImpl implements MemberService {

    private Library library;

    public MemberServiceImpl(Library library) {
        this.library = library;
    }

    @Override
    public void registerMember(int id, String name, String email) {

        Member member = new Member(id, name, email);

        boolean isExistMember = library.getMembers().stream()
                .anyMatch(libraryMember -> libraryMember.getId() == id);

        if (!isExistMember) {
            library.getMembers().add(member);
            System.out.println("Member Added Successfully ....");
        } else {
            throw new MemberAlreadyExistsException("Member Already Exists.");
        }
    }

    @Override
    public void removeMember(int id) {

        boolean isExistMember = library.getMembers().stream()
                .anyMatch(libraryMember -> libraryMember.getId() == id);

        if (isExistMember) {

            Iterator<Member> memberIterator = library.getMembers().iterator();

            while (memberIterator.hasNext()) {

                Member member = memberIterator.next();

                if (member.getId() == id) {

                    boolean hasBorrowedBooks = Arrays.stream(member.getBorrowedBooks())
                            .anyMatch(Objects::nonNull);

                    if (hasBorrowedBooks) {
                        throw new MemberHasBorrowedBooksException(
                                "Cannot Remove Member. Member Has Borrowed Books."
                        );
                    }

                    memberIterator.remove();
                    System.out.println("Member Removed Successfully.\n");
                    break;
                }
            }

        } else {
            throw new MemberNotFoundException(
                    "Member Not Found. Cannot Remove It."
            );
        }
    }

    @Override
    public Member searchMember(int id) {

        Optional<Member> memberSearch = library.getMembers().stream()
                .filter(member -> member.getId() == id)
                .findFirst();

        return memberSearch.orElseThrow(() ->
                new MemberNotFoundException("Member Not Found.")
        );
    }

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
