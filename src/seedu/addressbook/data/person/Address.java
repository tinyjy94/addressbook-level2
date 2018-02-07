package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #09-123, 608888";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person's address should be of format BLOCK, STREET, UNIT, POSTAL CODE";
    public static final String SEPARATOR = ",";
    public static final String ADDRESS_VALIDATION_REGEX = ".+,.+,.+,.+";

    private static final int BLOCK = 0;
    private static final int STREET = 1;
    private static final int UNIT = 2;
    private static final int POSTALCODE = 3;

    public Block block;
    public Street street;
    public Unit unit;
    public PostalCode postalCode;

    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        processAddress(trimmedAddress);
    }

    private void processAddress(String trimmedAddress) {
        String[] trimmedAddressComponents = trimmedAddress.split(SEPARATOR);
        block  = new Block(trimmedAddressComponents[BLOCK].trim());
        street = new Street(trimmedAddressComponents[STREET].trim());
        unit   = new Unit(trimmedAddressComponents[UNIT].trim());
        postalCode = new PostalCode(trimmedAddressComponents[POSTALCODE].trim());
    }

    /**
     * Returns address in format BLOCK, STREET, UNIT, POSTAL CODE
     */

    public String getAddress(){
        return block.getBlock() + ", " + street.getStreet() + ", " + unit.getUnit() + ", " + postalCode.getPostalCode();
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return getAddress();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.getAddress().equals(((Address) other).getAddress())); // state check
    }

    @Override
    public int hashCode() {
        return getAddress().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
