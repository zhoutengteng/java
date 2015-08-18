import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
// 能同时测试多个打包文件按
@Suite.SuiteClasses({
    CalculatorTest.class,
    //SquareTest.class
})
public class AllCalculatorTests {}
