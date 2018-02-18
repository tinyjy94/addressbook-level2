package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's birthday in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidBirthday(String)}
 */
public class Birthday {

    public static final String EXAMPLE = "12-03-1990";
    public static final String MESSAGE_BIRTHDAY_CONSTRAINTS =
            "Person birthday in format DD-MM-YYYY where DD is days and MM is months and YYYY is years";
    public static final String THIRTY_ONE_DAYS_REGEX = "((0[1-9]|[12]\\d|3[01])[-](0[13578]|1[02])[-]((19|[2-9]\\d)\\d{2}))";
    public static final String THIRTY_DAYS_REGEX = "((0[1-9]|[12]\\d|30)[-](0[469]|11)[-]((19|[2-9]\\d)\\d{2}))";
    public static final String LEAP_YEAR_REGEX = "(29[-]02[-]((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00)))";
    public static final String NON_LEAP_REGEX = "((0[1-9]|1\\d|2[0-8])[-]02[-]((19|[2-9]\\d)\\d{2}))";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given birthday.
     *
     * @throws IllegalValueException if given birthday string is invalid.
     */
    public Birthday(String birthday, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedBirthday = birthday.trim();
        if (!isValidBirthday(trimmedBirthday)) {
            throw new IllegalValueException(MESSAGE_BIRTHDAY_CONSTRAINTS);
        }
        this.value = trimmedBirthday;
    }

    /**
     * Returns true if the given string is a valid person birthday.
     */
    public static boolean isValidBirthday(String test) {
        return test.matches(THIRTY_ONE_DAYS_REGEX) || test.matches(THIRTY_DAYS_REGEX)
                                                   || test.matches(LEAP_YEAR_REGEX)
                                                   || test.matches(NON_LEAP_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Birthday // instanceof handles nulls
                && this.value.equals(((Birthday) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}

