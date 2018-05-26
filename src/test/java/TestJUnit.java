import org.junit.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TestJUnit {

    @BeforeClass
    public static void beforeClassTest(){

        System.out.println("BeforeClass 单元测试开始前执行初始化。。。。。。");
        System.out.println("------------------------------------------");
    }

    @Before
    public void beforeTest(){
        System.out.println("Before 单元测试方法开始前执行。。。。。。");
        System.out.println("-----------------------------------");
    }

    @Test
    public void test1() throws Exception{
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-mm-dd");
        Date             sdate = sdf.parse("2017-05-16");
        Date             edate = sdf.parse("2017-05-25");
        int betweenDays = this.getBetweenDays(sdate, edate);


        System.out.println("相差天数：" + betweenDays);
        assertEquals("相差天数：", 9, betweenDays);
    }

    @Test
    @Ignore
    public void test2() throws Exception{
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-mm-dd");
        Date             sdate = sdf.parse("2017-05-16");
        Date             edate = sdf.parse("2017-05-30");
        int betweenDays = this.getBetweenDays(sdate, edate);

        System.out.println("相差天数：" + betweenDays);
        assertEquals("相差天数：", 9, betweenDays);
    }

    @After
    public void afterTest(){
        System.out.println("after 单元测试方法结束后执行。。。。。。");
    }

    @AfterClass
    public static void afterClassTest(){
        System.out.println("-----------------------------");
        System.out.println("afterClass 单元测试结束之后运行。。。。。。");
    }

    protected int getBetweenDays(Date sdate, Date edate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdate);
        long stime = calendar.getTimeInMillis();

        calendar.setTime(edate);
        long etime = calendar.getTimeInMillis();

        long lBetweenDays = (etime - stime) / (1000 * 24 * 3600);

        int iBetweenDate = Integer.parseInt(String.valueOf(lBetweenDays));
        return iBetweenDate;

    }
}
