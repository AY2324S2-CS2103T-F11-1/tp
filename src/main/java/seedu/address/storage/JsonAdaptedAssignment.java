package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Assignment;

/**
 * Jackson-friendly version of {@link Assignment}.
 */
class JsonAdaptedAssignment {

    private final String assignmentName;
    private final int score;

    /**
     * Constructs a {@code JsonAdaptedAssignment} with the given {@code assignmentName}.
     */
    @JsonCreator
    public JsonAdaptedAssignment(@JsonProperty("assignmentName") String assignmentName,
        @JsonProperty("Score") int score) {
        this.assignmentName = assignmentName;
        this.score = score;
    }

    @JsonProperty("assignmentName")
    public String getName() {
        return assignmentName;
    }

    @JsonProperty("Score")
    public int getScore() {
        return score;
    }

    /**
     * Converts this Jackson-friendly adapted assignment object into the model's {@code Assignment} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted assignment.
     */
    public Assignment toModelType() throws IllegalValueException {
        if (!Assignment.isValidAssignmentName(assignmentName)) {
            throw new IllegalValueException(Assignment.MESSAGE_CONSTRAINTS);
        }
        return new Assignment(assignmentName, score);
    }

}
