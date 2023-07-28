class Solution {
    public int maximum69Number (int num) {
        
        int[] digits = new int[4];
        int size = 0;
        while (num > 0) {
            digits[size++] = num % 10;
            num /= 10;
        }
        for (int i = size - 1; i >= 0; i--) {
            if (digits[i] == 6) {
                digits[i] = 9;
                break;
            }
        }
        int ret = 0;
        for (int i = size - 1; i >= 0; i--) {
            ret = ret * 10 + digits[i];
        }
        return ret;
    }
}