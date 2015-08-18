import static org.junit.Assert.*;
// 下面这两个包 是对与自己选择运行器 准备的
//import org.junit.internal.runners.TestClass; 发现过时
import org.junit.runner.RunWith;

//把若干种情况变成参数一次性测试，因为一个测试只有一个断言可以使用
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

// 调用运行器 这里可省 和不加是一样的效果 加了这里 也要加对应的package
/////@RunWith(TestClassRunner.class)

// 使用参数的方法时添加的 因为添加了特殊功能嘛
@RunWith(Parameterized.class)
public class CalculatorTest {
    private static Calculator calculator = new Calculator();
    private int param;
    private int result;
    @Before
    public void setUp() throws Exception {
        calculator.clear();
    }
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {2, 4},
            {0, 0},
            {-3, 9},
        });
    }
   //构造函数,对变量进行初始化 顺序和参亮的顺序相同
    public CalculatorTest(int param, int result) {
        this.param = param;
        this.result = result;
    }

    @Test
    public void testAdd() {
        calculator.add(2);
        calculator.add(3);
        assertEquals(5, calculator.getResult());
    }

    @Test
    public void testSubstract() {
        calculator.add(10);
        calculator.substract(2);
        assertEquals(8, calculator.getResult());
    }
    
    @Ignore("Multiply() Not yet implemented")
    @Test
    public void testMultiply() {
    }

    @Test
    public void testDivide() {
        calculator.add(8);
        calculator.divide(2);
        assertEquals(4, calculator.getResult());
    }

    @Test(timeout = 1000)
    public void squareRoot(){
        calculator.squareRoot(4);
        assertEquals(2, calculator.getResult());
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZero() {
        calculator.divide(0);
    }

    @Test
    public void square() {
        calculator.square(param);
        assertEquals(result, calculator.getResult());
    }
}
