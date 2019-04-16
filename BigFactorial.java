import java.util.Scanner;

public class BigFactorial {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Factorial of: ");
		int n = sc.nextInt();
		int[] factorial = {1};
		for (int i = 1; i <= n; i++) {
			int[] arrN = convertToArr(i);
			factorial = multiply(factorial, arrN);
		}
		System.out.println(prettyPrint(factorial));
		sc.close();
	}
    
    public static int[] multiply(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int pos = c.length - 1;
        int count = c.length - 1;
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = b.length - 1; j >= 0; j--) {
                int temp = a[i] * b[j];
                c[pos] += temp;
                pos--;
            }
            pos = --count;
        }
        for (int k = c.length - 1; k >= 1; k--) {
            c[k - 1] += c[k] / 10;
            c[k] %= 10;
        }
        return c;
    }
    
		
	public static int[] convertToArr(int num) {
		int len = String.valueOf(num).length();
		int[] changed = new int[len];
		for (int i = changed.length - 1; i >= 0; i--) {
			changed[i] = num % 10;
			num /= 10;
		}
		return changed;
	}
	

    public static String prettyPrint(int[] num) {
        String s = "";
        boolean zeroPad = true;
        for (int i = 0; i < num.length; i++) {
            if (zeroPad && num[i] == 0) {
                continue;
            } else if (zeroPad && num[i] > 0) {
                zeroPad = false;
            }
            s += num[i];
        }
        return s;
    }

}
