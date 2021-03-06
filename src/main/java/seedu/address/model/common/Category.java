package seedu.address.model.common;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Category in SOChedule.
 * Guarantees: immutable; categoryName is valid as declared in {@link #isValidCategoryName(String)}.
 */
public class Category {
    public static final String MESSAGE_CONSTRAINTS =
            "Category names should be alphanumeric, without any spaces and be no longer than 15 characters.";

    public static final String VALIDATION_REGEX = "\\p{Alnum}+";
    public static final int MAX_LENGTH = 15;

    public final String categoryName;

    /**
     * Constructs a {@code Category}.
     *
     * @param categoryName A valid category name.
     */
    public Category(String categoryName) {
        requireNonNull(categoryName);
        checkArgument(isValidCategoryName(categoryName), MESSAGE_CONSTRAINTS);
        this.categoryName = categoryName;
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidCategoryName(String test) {
        return test.matches(VALIDATION_REGEX) && test.length() <= MAX_LENGTH;
    }

    /**
     * Returns the name of the category.
     *
     * @return the name of the category.
     */
    public String getCategoryName() {
        return this.categoryName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Category // instanceof handles nulls
                && categoryName.equals(((Category) other).categoryName)); // state check
    }

    @Override
    public int hashCode() {
        return categoryName.hashCode();
    }

    @Override
    public String toString() {
        return categoryName;
    }

}
