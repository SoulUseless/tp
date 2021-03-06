package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_TASK_DEADLINE_TASKONE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TASK_NAME_TASKONE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TASK_PRIORITY_TASKONE;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.common.Category;
import seedu.address.model.common.Date;
import seedu.address.model.common.Name;
import seedu.address.model.common.Tag;
import seedu.address.model.task.Priority;
import seedu.address.model.task.Task;
import seedu.address.model.util.SampleDataUtil;


/**
 * A utility class to help with building Task objects.
 */
public class TaskBuilder {
    public static final String DEFAULT_NAME = VALID_TASK_NAME_TASKONE;
    public static final String DEFAULT_DATE = VALID_TASK_DEADLINE_TASKONE;
    public static final String DEFAULT_PRIORITY = VALID_TASK_PRIORITY_TASKONE;

    private Name name;
    private Date deadline;
    private Priority priority;
    private Set<Tag> tags;
    private Set<Category> categories;

    /**
     * Creates a {@code TaskBuilder} with the default details.
     */
    public TaskBuilder() {
        name = new Name(DEFAULT_NAME);
        deadline = new Date(DEFAULT_DATE);
        priority = new Priority(DEFAULT_PRIORITY);
        tags = new HashSet<>();
        categories = new HashSet<>();
    }

    /**
     * Initializes the TaskBuilder with the data of {@code taskToCopy}.
     */
    public TaskBuilder(Task taskToCopy) {
        name = taskToCopy.getName();
        deadline = taskToCopy.getDeadline();
        priority = taskToCopy.getPriority();
        tags = taskToCopy.getTags();
        categories = taskToCopy.getCategories();
    }

    /**
     * Sets the {@code Name} of the {@code Task} that we are building.
     */
    public TaskBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Sets the {@code Deadline} of the {@code Task} that we are building.
     */
    public TaskBuilder withDeadline(String date) {
        this.deadline = new Date(date);
        return this;
    }

    /**
     * Sets the {@code Priority} of the {@code Task} that we are building.
     */
    public TaskBuilder withPriority(String priority) {
        this.priority = new Priority(priority);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Task} that we are building.
     */
    public TaskBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Parses the {@code categories} into a {@code Set<Category>} and set it to the {@code Task} that we are building.
     */
    public TaskBuilder withCategories(String ... tags) {
        this.categories = SampleDataUtil.getCategorySet(tags);
        return this;
    }

    public Task build() {
        return new Task(name, deadline, priority, categories, tags);
    }

    /**
     * Builds the task with completion status set as complete.
     */
    public Task buildCompletedTask() {
        Task newTask = build();
        newTask.markTaskAsDone();
        return newTask;
    }
}
