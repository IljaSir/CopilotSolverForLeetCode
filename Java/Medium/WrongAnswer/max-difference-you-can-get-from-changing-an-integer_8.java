class Solution {
    public int maxDiff(int num) {
        
        int a = num, b = num;
        int[] digits = new int[10];
        int[] digits2 = new int[10];
        while (num > 0) {
            digits[num % 10]++;
            digits2[num % 10]++;
            num /= 10;
        }
        int x = 0, y = 0;
        for (int i = 0; i < 10; i++) {
            if (digits[i] > 0) {
                x = i;
                break;
            }
        }
        for (int i = 9; i >= 0; i--) {
            if (digits2[i] > 0) {
                y = i;
                break;
            }
        }
        int a1 = 0, b1 = 0;
        int i = 0;
        while (a > 0) {
            if (a % 10 == x) {
                a1 += y * Math.pow(10, i);
            } else {
                a1 += a % 10 * Math.pow(10, i);
            }
            a /= 10;
            i++;
        }
        i = 0;
        while (b > 0) {
            if (b % 10 == y) {
                b1 += x * Math.pow(10, i);
            } else {
                b1 += b % 10 * Math.pow(10, i);
            }
            b /= 10;
            i++;
        }
        return a1 - b1;
    }
}