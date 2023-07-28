class Solution {
    public int maximum69Number (int num) {
        
        int result = 0;
        int factor = 1;
        boolean found = false;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 6 && !found) {
                digit = 9;
                found = true;
            }
            result += digit * factor;
            factor *= 10;
            num /= 10;
        }
        return result;
    }
}