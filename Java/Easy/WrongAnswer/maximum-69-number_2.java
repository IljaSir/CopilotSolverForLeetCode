class Solution {
    public int maximum69Number (int num) {
        
        int[] digits = new int[4];
        for (int i = 0; i < 4; i++) {
            digits[i] = num % 10;
            num /= 10;
        }
        for (int i = 3; i >= 0; i--) {
            if (digits[i] == 6) {
                digits[i] = 9;
                break;
            }
        }
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = result * 10 + digits[i];
        }
        return result;
    }
}