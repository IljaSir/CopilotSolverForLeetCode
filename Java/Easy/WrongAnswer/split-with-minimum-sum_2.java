class Solution {
    public int splitNum(int num) {
        
        int[] digits = new int[10];
        while (num > 0) {
            digits[num % 10]++;
            num /= 10;
        }
        int sum = 0;
        for (int i = 1; i <= 9; i++) {
            if (digits[i] > 0) {
                sum += i * (digits[i] + 1);
            }
        }
        if (digits[0] > 0) {
            sum += digits[0] - 1;
        }
        return sum;
    }
}