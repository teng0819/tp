package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;
import java.util.function.Predicate;

import seedu.address.logic.commands.ShowCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.employee.Employee;
import seedu.address.model.employee.predicate_checker.DepartmentContainsKeywordsPredicate;
import seedu.address.model.employee.predicate_checker.EmailContainsKeywordsPredicate;
import seedu.address.model.employee.predicate_checker.NameContainsKeywordsPredicate;
import seedu.address.model.employee.predicate_checker.PhoneContainsKeywordsPredicate;
import seedu.address.model.employee.predicate_checker.PositionContainsKeywordsPredicate;

public class ShowCommandParser implements Parser<ShowCommand> {

    public ShowCommand parse(String args) throws ParseException {
        String input = args.trim();

        if (input.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ShowCommand.MESSAGE_USAGE));
        }

        Predicate<Employee> predicate = employee -> true;

        // Name
        if (input.contains("/n")) {
            String value = extract(input, "/n");
            predicate = predicate.and(
                    new NameContainsKeywordsPredicate(Arrays.asList(value.split("\\s+")))
            );
        }

        // Department
        if (input.contains("/d")) {
            String value = extract(input, "/d");
            predicate = predicate.and(
                    new DepartmentContainsKeywordsPredicate(Arrays.asList(value.split("\\s+")))
            );
        }

        // Position
        if (input.contains("/p")) {
            String value = extract(input, "/p");
            predicate = predicate.and(
                    new PositionContainsKeywordsPredicate(Arrays.asList(value.split("\\s+")))
            );
        }

        // Email
        if (input.contains("/e")) {
            String value = extract(input, "/e");
            predicate = predicate.and(
                    new EmailContainsKeywordsPredicate(Arrays.asList(value.split("\\s+")))
            );
        }

        // Phone
        if (input.contains("/ph")) {
            String value = extract(input, "/ph");
            predicate = predicate.and(
                    new PhoneContainsKeywordsPredicate(Arrays.asList(value.split("\\s+")))
            );
        }

        return new ShowCommand(predicate);
    }

    /**
     * Extracts value after a flag (e.g. /n, /d) until next flag or end.
     */
    private String extract(String input, String flag) {
        String[] parts = input.split(flag, 2);

        if (parts.length < 2) {
            return "";
        }

        String after = parts[1].trim();

        int nextFlagIndex = after.indexOf(" /");
        if (nextFlagIndex != -1) {
            return after.substring(0, nextFlagIndex).trim();
        }

        return after;
    }
}