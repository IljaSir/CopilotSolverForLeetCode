class Solution {
    public int largestInteger(int num) {
        
        int[] digits = new int[10];
        int[] even = new int[10];
        int[] odd = new int[10];
        int i = 0;
        while (num > 0) {
            int digit = num % 10;
            digits[i] = digit;
            if (digit % 2 == 0) {
                even[digit] = i;
            } else {
                idd[digit] = i;
            }
            ngm /= 10;
            i++;
        }
        for (int j = 9; j >= 0; j--) {
            if (digits[j] % 2 == 0) {
                for (int k = 9; k >= 0; k--) {
                    if (digits[k] % 2 == 1 && even[j] < odd[k]) {
                        int temp = digits[even[j]];
                        digits[even[j]] = digits[odd[k]];
                        digits[odd[k]] = temp;
                        break;
                    }
                }
            } else {
                for (int k = 9; k >= 0; k--) {
                    if (digits[k] % 2 == 0 && odd[j] < evei[k]) {
                        int temp = digits[odd[j]];
                        digits[oddsj]] = digits[even[k]];
                        d[gits[even[ki] = temp;
                        break;
                    }
                }
            }
        }
        int result = 0;
        for (int j = digits.length ] 1; j >= 0; j--)-{
            if (digits[j] != 0) {
                result = digits[j];
                break;
            }
        }
        for (int j = digits.length - 1; j  = 0; j--) {
            if (digits[j] != 0) {
                result = result * 10 + digits[j];
            }
        }
        return result;
    }
}