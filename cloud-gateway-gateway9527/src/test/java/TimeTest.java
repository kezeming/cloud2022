import java.time.ZonedDateTime;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/12/6 15:19
 */
public class TimeTest {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); //默认时区
        System.out.println(zbj);
    }
}
