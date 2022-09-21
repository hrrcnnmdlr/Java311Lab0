package lab0;

public class Variant14 {

    public int Integer(int num) {
        //Дано трехзначное число. В нем зачеркнули первую справа цифру и приписали ее слева. Вывести полученное число.
        assert num > 100 && num < 999: "The number must be three digits";
        int third = num % 10;
        num = num / 10;
        num = third * 100 + num;
        return num;
    }

    public boolean Boolean(int A, int B, int C) {
        //Даны три целых числа: A, B, C. Проверить истинность высказывания: «Ровно одно из чисел A, B, C положительное».
        return A > 0 && B < 0 && C < 0 || B > 0 && A < 0 && C < 0 || C > 0 && B < 0 && A < 0;
    }

    public static int[] If(int a, int b, int c) {
        //If14. Даны три числа. Вывести вначале наименьшее, а затем наибольшее из данных чисел.
        int min = a;
        int max = a;
        if (b > max) max = b;
        else if (c > max) max = b;
        if (b < min) min = b;
        else if (c < min) min = b;
        return new int[]{min, max};
    }

    public double[] Case(int num, double value) {
        /*Элементы равностороннего треугольника пронумерованы следующим образом:
        1 — сторона a, 2 — радиус R1 вписанной окружности (R1 = a·(3)^(1/2)/6),
        3 — радиус R2 описанной окружности (R2 = 2·R1), 4 — площадь S = a^2·3^(1/2))/4.
        Дан номер одного из этих элементов и его значение.
        Вывести значения остальных элементов данного треугольника (в том же порядке).
         */
        double a = 0, r1, r2, s;
        switch (num) {
            case (1) -> {
                a = value;
            }
            case (2) -> {
                a = value / (Math.sqrt(3) / 6);
            }
            case (3) -> {
                a = value / (2 * Math.sqrt(3) / 6);
            }
            case (4) -> {
                a = Math.sqrt(value / (Math.sqrt(3) / 4));
            }
        }
        r1 = (a * Math.sqrt(3) / 6);
        r2 = (2 * a * Math.sqrt(3) / 6);
        s = a * a * Math.sqrt(3) / 4;
        System.out.println(a);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(s);
        return new double[]{a, r1, r2, s};
    }

    public static int[] For (int N) {
        /*
        Дано целое число N (> 0). Найти квадрат данного числа, используя для его вычисления следующую формулу:
        N2 = 1 + 3 + 5 + … + (2·N – 1).
        После добавления к сумме каждого слагаемого выводить текущее значение суммы
        (в результате будут выведены квадраты всех целых чисел от 1 до N).
         */
        int[] answer = new int[N];
        answer[0] = 1;
        System.out.println(answer[0]);
        for (int i = 3, k = 1; k < N; i=i+2, k++) {
            answer[k] = answer[k-1] + i;
            //System.out.println(answer[k]);
        }
        return answer;
    }

    public static double[] While(double A) {
        /*
            Дано число A (> 1). Вывести наибольшее из целых чисел K, для которых сумма 1 + 1/2 + … + 1/K
            будет меньше A, и саму эту сумму.
         */
        assert A > 1 && A < 2: "The number must be more than 1 and less than 2";
        int k = 0;
        double sum = 0;
        while (sum + Math.pow(k+1, -1) < A) {
            sum += Math.pow(++k, -1);
        }
        //System.out.println(k + "  " + sum);
        return new double[] {k, sum};
    }

    public static double[] Array(double[] A, int N) {
        /*
        Дан массив A размера N. Вывести вначале его элементы с четными номерами (в порядке возрастания номеров),
        а затем — элементы с нечетными номерами (также в порядке возрастания номеров):
        A2,    A4,    A6,    …,    A1,    A3,    A5,    … .
        Условный оператор не использовать.
         */
        double[] answer = new double[N];
        for (int i = 0, k = 0; i < N-1 ; i++, k++) {
            answer[N / 2 + k] = A[i];
            answer[k] = A[++i];
        }
        if (N % 2 == 1) {
            answer[N - 1] = A[N - 1];
        }
        //System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static int[] Matrix(int[][] A, int M) {
        /*
        Дана квадратная матрица A порядка M. Начиная с элемента A1,1,
        вывести ее элементы следующим образом («уголками»):
        все элементы первого столбца;
        элементы последней строки, кроме первого (уже выведенного) элемента;
        оставшиеся элементы второго столбца;
        оставшиеся элементы предпоследней строки и т. д.;
        последним выводится элемент A1,M.
         */

        int[] answer = new int[M*M];
        for(int i = 0, v = 0; i < M; ++i){

            for(int j = 0; j < M - i; ++j){
                //System.out.print(A[i][j] + " ");
                answer[v++] = A[i][j];
            }

            for(int j = i + 1; j < M; ++j){
                //System.out.print(A[M - i - 1][j] + " ");
                answer[v++] = A[M - i - 1][j];
            }
        }
        return answer;
    }


    public static void main(String... strings) {
        System.out.println("Start of zero lab");
        System.out.println("Done!!!");
    }
}

