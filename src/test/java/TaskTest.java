import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}