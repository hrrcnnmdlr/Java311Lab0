package lab0;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Variant14Test {
    // Int14
    @Test(dataProvider = "integerProvider")
    public void inputTest(int num, long answer) {
        assertEquals(new Variant14().Integer(num), answer);
    }
    @Test(expectedExceptions = AssertionError.class)
    public void switchNegativeTest() {
        new Variant14().Integer(45);
        new Variant14().Integer(4);
        new Variant14().Integer(4545);
    }
    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][] { { 234, 423}, { 523, 352 }};
    }

    //Bool
    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int A, int B, int C, boolean answer) {
        assertEquals(new Variant14().Boolean(A, B, C), answer);
    }
    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] { { 5, -1, -8, true }, { -5, -2, -9, false }, { -2, 3, 5, false } };
    }

    //If
    @Test(dataProvider = "ifProvider")
    public void ifTest(int a, int b, int c, int[] answer) {
        assertEquals(new Variant14().If(a, b, c), answer);
    }
    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][] { { 2, 7, 3, new int[]{2, 7} }, { 0, 0, 0, new int[]{0, 0} }};
    }


    //Switch
    @Test(dataProvider = "switchProvider")
    public void switchTest(int num, double value, double[] answer) {
        assertEquals(new Variant14().Case(num, value), answer);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][] { { 1, 4, new double[]{4, 1.1547005383792515, 2.309401076758503, 6.928203230275509 } },
                { 3, 2.3094, new double[]{ 3.9999981349995655, 1.1547, 2.3094, 6.928196769725997}}};
    }

    //For
    @Test(dataProvider = "forProvider")
    public void forTest(int N, int[] answer) {
        assertEquals(new Variant14().For(N), answer);
    }
    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] { { 5, new int[]{1, 4, 9, 16, 25} },
                { 3, new int[]{1, 4, 9}}, { 6, new int[]{1, 4, 9, 16, 25, 36} } };
    }

    //While
    @Test(dataProvider = "whileProvider")
    public void whileTest(double a, double[] answer) {
        assertEquals(new Variant14().While(a), answer);
    }
    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] { { 1.6, new double[] {2, 1.5} }, { 1.9, new double[] {3, 1.5 + Math.pow(3, -1)} }};
    }
    @Test(expectedExceptions = AssertionError.class, dataProvider = "negativeWhileProvider")
    public void negativeWhileTest(double a) {
        new Variant14().While(a);
    }
    @DataProvider
    public Object[][] negativeWhileProvider() {
        return new Object[][] { { 0.3 }, {-9}, { 2 } };
    }

    //Array
    @Test(dataProvider = "arrayProvider")
    public void arrayTest(double[] array, int n, double[] answer) {
        assertEquals(new Variant14().Array(array, n), answer);
    }
    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] { { new double[] { 10, 2, 3 }, 3, new double[] {  2, 10, 3 } },
                { new double[] { 10, 2, 13 }, 3, new double[] { 2, 10, 13 }  },
                { new double[] { 4, 3, 5, -4, 9, 2 }, 6, new double[] { 3, -4, 2, 4, 5, 9 } } };
    }

    //Matrix
    @Test(dataProvider = "matrixProvider")
    public void MatrixTest(int[][] input, int n, int[] output) {
        assertEquals(new Variant14().Matrix(input, n), output);
    }
    @DataProvider
    public Object[][] matrixProvider() {
        int[][] input = {{2, 3, 6, 9},
                {34, 98, -9, 2},
                {-4, 2, 1, 6},
                {-98, 8, 1, 5}};

        int[] input1 = {2, 3, 6, 9, 8, 1, 5, 34, 98, -9, 1, 6, -4, 2, 2, -98 };

        int[][] input2 = {{-98, 8, 1, 5},
                {-4, 2, 1, 6},
                {34, 98, -9, 2},
                {2, 3, 6, 9}};

        int[] input3 = {-98, 8 ,1, 5, 3, 6, 9 ,-4, 2 ,1, -9, 2 ,34, 98, 6, 2 };

        return new Object[][] { {input, 4, input1}, { input2, 4, input3 } };

    }
}
