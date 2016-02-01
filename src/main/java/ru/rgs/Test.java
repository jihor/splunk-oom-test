package ru.rgs;

/**
 * (С) RGS Group, http://www.rgs.ru
 *
 * @author jihor (dmitriy_zhikharev@rgs.ru)
 *         Created on 2016-01-28
 */
public class Test {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Test.class);
    public static final int repeats = 1;

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            for (int i = 0; i < repeats; i++) {
                log.info("This is an INFO level message");
            }
            for (int i = 0; i < repeats; i++) {
                log.debug("This is a DEBUG level message");
            }
            for (int i = 0; i < repeats; i++) {
                log.trace("This is a TRACE level message");
            }
            Thread.sleep(1000);
        }
    }
}
