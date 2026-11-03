
package services.MembersService;

import Entities.Member;

/**
 * Defines the operations available for managing library members.
 */
public interface MemberService {

    /**
     * Registers a new member in the library.
     *
     * @param id    the unique identifier of the member
     * @param name  the member's name
     * @param email the member's email address
     */
    void registerMember(int id, String name, String email);

    /**
     * Removes a registered member using their ID.
     *
     * @param id the ID of the member to remove
     */
    void removeMember(int id);

    /**
     * Searches for a member using their ID.
     *
     * @param id the ID of the member to search for
     * @return the matching member, or null if no member is found
     */
    Member searchMember(int id);

    /**
     * Displays all registered members in the library.
     */
    void displayAllMembers();
}
