class Solution {
    public int splitNum(int num) {
        
        if (num < 10) {
            return num;
        }
        int[] digits = new int[10];
        while (num > 0) {
            digits[num % 10]++;
            num /= 10;
        }
        int[] result = new int[2];
        for (int i = 9; i >= 0; i--) {
            int index = (result[1] + digits[i]) % 2;
            result[index] = result[index] * 10 + i;
            result[1 - index] *= 10;
            digits[i]--;
        }
        return result[0] + result[1];
    }
}