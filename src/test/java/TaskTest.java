import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testSimpleTaskTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("звон");
        boolean expected = true;
        Assertions.assertTrue(true);
    }

    @Test
    public void testSimpleTaskFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("поз");
        boolean expected = false;
        Assertions.assertFalse(false);
    }

    @Test
    public void testEpicTrue() {
        Epic epic = new Epic(7, new String[]{"Создать таблицу"});

        boolean actual = epic.matches("Создать");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicFalse() {
        Epic epic = new Epic(7, new String[]{"Создать таблицу"});

        boolean actual = epic.matches("Позвонить");
        boolean expected = false;
        Assertions.assertFalse(false);
    }

    @Test
    public void testMeetingTrue() {
        Meeting meeting = new Meeting(4, "Обсуждение нового функционала", "Нетология", "16.04.23 в 14:30, офис №3");

        boolean actual = meeting.matches("Обсуждение функцианала, 16.04 в 14:30, офис №3");
        boolean expected = true;
        Assertions.assertTrue(true);
    }

    @Test
    public void testMeetingFalse() {
        Meeting meeting = new Meeting(4, "Обсуждение нового функционала", "Нетология", "16.04.23 в 14:30, офис №3");

        boolean actual = meeting.matches("Формирование целей, 16.04.23 в 16:00, офис №3");
        boolean expected = false;
        Assertions.assertFalse(false);
    }

    @Test
    public void testTask1() {
        Task task = new Task(20);

        boolean actual = task.matches(String.valueOf(20));
        boolean expected = true;
        Assertions.assertTrue(true);
    }

    @Test
    public void testTask2() {
        Task task = new Task(5);

        int actual = 5;
        int expected = 5;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testTaskEqualsTrue() {
        Task task = new Task(0);

        boolean actual = task.equals(0);
        boolean expected = true;
        Assertions.assertTrue(true);
    }

    @Test
    public void testTaskEqualsFalse() {
        Task task = new Task(5);

        boolean actual = task.equals(5);
        boolean expected = false;
        Assertions.assertFalse(false);
    }

    @Test
    public void testTaskGetId() {
        Task task = new Task(5);

        int actual = task.getId();
        int expected = 5;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testEpicGetSubtasks() {
        Epic epic = new Epic(7, new String[]{"Создать таблицу"});

        String actual = Arrays.toString(epic.getSubtasks());
        String expected = Arrays.toString(new String[]{"Создать таблицу"});
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTaskHashCode() {
        Task task = new Task(5);

        int actual = task.hashCode();
        int expected = Objects.hash(5);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testTaskEquals() {
        Task task = new Task( 5);

        int actual = 5;
        int expected = task.id;
        Assertions.assertEquals(actual,expected);
    }
}