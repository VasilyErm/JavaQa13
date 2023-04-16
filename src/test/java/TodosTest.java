import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void simpleTaskEpicMeetingTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Проработка функционала 16.04");

        String[] subtasks = {"Проработка", "Нетология", "функционал"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Разработка нового функционала",
                "Приложене Нетология",
                "16.04 после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("функционал");
        Task[] expected = {simpleTask, epic, meeting};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void simpleTaskEpicTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Проработка функционала 16.04");

        String[] subtasks = {"Проработка", "Нетология", "функционал"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Разработка нового функционала",
                "Приложене Нетология",
                "16.04 после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Проработка");
        Task[] expected = {simpleTask, epic};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void EpicMeetingTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Проработка функционала 16.04");

        String[] subtasks = {"Проработка", "Нетология", "функционал"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Разработка нового функционала",
                "Приложене Нетология",
                "16.04 после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Нетология");
        Task[] expected = {epic, meeting};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void falseTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Проработка функционала 16.04");

        String[] subtasks = {"Проработка", "Нетология", "функционал"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Разработка нового функционала",
                "Приложене Нетология",
                "16.04 после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Футбол");
        Task[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void meetingTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Проработка функционала 16.04");

        String[] subtasks = {"Проработка", "Нетология", "функционал"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Разработка нового функционала",
                "Приложене Нетология",
                "16.04 после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Разработка");
        Task[] expected = {meeting};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void meetingTestGetId() {
        Meeting meeting = new Meeting(555, "Разработка нового функционала", "Приложене Нетология","16.04 после обеда");

        int actual = meeting.getId();
        int expected = 555;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingTestGetTopic() {
        Meeting meeting = new Meeting(555, "Разработка нового функционала", "Приложене Нетология","16.04 после обеда");

        String actual = meeting.getTopic();
        String expected = "Разработка нового функционала";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingTestGetProject() {
        Meeting meeting = new Meeting(555, "Разработка нового функционала", "Приложене Нетология","16.04 после обеда");

        String actual = meeting.getProject();
        String expected = "Приложене Нетология";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingTestGetStart() {
        Meeting meeting = new Meeting(555, "Разработка нового функционала", "Приложене Нетология","16.04 после обеда");

        String actual = meeting.getStart();
        String expected = "16.04 после обеда";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void simpleTaskId() {
        SimpleTask simpleTask = new SimpleTask(5, "Проработка функционала 16.04");

        int actual = simpleTask.id;
        int expected = 5;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void simpleTaskGetTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Проработка функционала 16.04");

        String actual = simpleTask.getTitle();
        String expected = "Проработка функционала 16.04";
        Assertions.assertEquals(expected, actual);
    }
}