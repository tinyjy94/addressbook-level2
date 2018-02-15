package seedu.addressbook.data.person;

/**
 * Represents a Person's Contact in the address book.
 * A class that extracts commonalities and is the parent class of Phone, Email and Address class
 */

public class Contact {

    public String value;
    private boolean isPrivate;

    public Contact (boolean isPrivate){
        this.isPrivate = isPrivate;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }

}
