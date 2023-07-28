class Solution {
    public int splitNum(int num) {
        
        int[] digits = new int[10];
        while (num > 0) {
            digits[num % 10]++;
            num /= 10;
        }
        int num1 = 0, num2 = 0, carry = 0;
        for (int i = 1; i <= 9; i++) {
            int n = digits[i];
            if (n % 2 == 0) {
                num1 = num1 * 10 + n / 2;
                num2 = num2 * 10 + n / 2;
            } else {
                if (carry == 1) {
                    num1 = num1 * 10 + n / 2 + 1;
                    num2 = num2 * 10 + n / 2;
                } else {
                    num1 = num1 * 10 + n / 2;
                    num2 = num2 * 10 + n / 2 + 1;
                }
                carry = 1 - carry;
            }
        }
        return num1 + num2;
    }
}