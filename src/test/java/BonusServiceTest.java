import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.MVN.services.BonusService;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredUnderLimit() {
        BonusService service = new BonusService();

        long amount = 2000;
        boolean registered = false;
        long expected = 20;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 60_000;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);


        Assertions.assertEquals(expected, actual);
    }
}