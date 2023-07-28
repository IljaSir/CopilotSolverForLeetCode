class Solution {
    public int largestInteger(int num) {
        
        int[] digits = new int[10];
        while (num > 0) {
            digits[num % 10]++;
            num /= 10;
        }
        int result = 0;
        for (int i = 9; i >= 0; i--) {
            while (count[i]-- > 0) {
                result = result * 10 + i;
            }
        }
        return result;
    }
}
    }
}