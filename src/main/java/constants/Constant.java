package constants;

import java.time.Duration;

public class Constant {
    public static class TimeoutVariable{
        //переменная для задания значения неявного ожидания
        public static final Duration IMPLICIT_WAIT = Duration.ofSeconds(4);
    }

    public static class Urls{
        //переменная для передачи ссылки в драйвер
        public static final String RTS_TENDER_HOME_PAGE = "https://www.rts-tender.ru/";
    }
}
