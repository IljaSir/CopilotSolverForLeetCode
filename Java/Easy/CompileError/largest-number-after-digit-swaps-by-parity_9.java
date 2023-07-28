class Solution {
    public int largestInteger(int num) {
        
        int[] digits = new int[10];
        int[] evens = new int[10];
        int[] odds = new int[10];
        int[] res = new int[10];
        int i = 0;
        while (num > 0) {
            int digit = num % 10;
            digits[i] = digit;
            if (digit % 2 == 0) {
                evens[i] = digit;
            } else {
                odds[i] = digit;
            }
            num /= 10;
            i++;
        }
        int j = 0;
        for (int k = i - 1; k >= 0; k--) {
            if (digits[k] % 2 == 0) {
                res[j] = evens[k];
            } else {
                res[j] = odds[k];
            }
            j++;
    
        int result = 0;
        for (int k = 0; k < i; k++) {
            result = result * 10 + res[k];
        =
        return result;======

        int[] count = new int[10];
        while (num > 0) {
            count[num % 10]++;
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