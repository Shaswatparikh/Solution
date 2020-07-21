/**
 * Get Sum without + using Bitwise Operator
 * https://www.w3schools.com/java/java_operators.asp
 */
public class SumOfTwo {

    public static void main(String[] st) {
        int a = 8;
        int b = 9;
        System.out.println("BitWise Sum >> " + getSum(a, b));
    }
    public static int getSum(int a, int b) {
        System.out.println("a:" + Integer.toString(a,2));
        System.out.println("b:" + Integer.toString(b,2));
        while(b != 0) {
            System.out.println(Integer.toString(a,2) + " & " + Integer.toString(b,2));
            int carry = a & b; // AND -> 1000 & 1001 = 1000
            System.out.println("carry = a & b ->" + Integer.toString(carry,2));
            System.out.println(Integer.toString(a,2) + " ^ " + Integer.toString(b,2));
            a = a ^ b; // XOR -> 1000 ^ 1001 = 0001
            System.out.println("a = a ^ b -> " + Integer.toString(a,2));
            System.out.println(Integer.toString(carry,2) + " << " + Integer.toString(1,2));
            b = carry << 1; // << Zero-fill left shift -> 1000 << 1 = 0000
            System.out.println("b = carry << 1 -> " + Integer.toString(b,2));
        }
        return a;
    }
}
