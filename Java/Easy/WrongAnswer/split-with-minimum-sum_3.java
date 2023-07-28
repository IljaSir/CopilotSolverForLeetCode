class Solution {
    public int splitNum(int num) {
        
        int[] digits = new int[10];
        while (num > 0) {
            digits[num % 10]++;
            num /= 10;
        }
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += i * digits[i];
        }
        int min = sum;
        for (int i = 1; i < 10; i++) {
            if (digits[i] == 0) {
                continue;
            }
            int s = sum;
            for (int j = 1; j < 10; j++) {
                int diff = Math.abs(digits[i] - digits[j]);
                if (digits[i] < digits[j]) {
                    s += j * diff;
                } else {
                    s -= j * diff;
                }
            }
            min = Math.min(min, s);
        }
        return min;
    }
}