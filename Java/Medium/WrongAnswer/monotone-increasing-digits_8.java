class Solution {
    public int monotoneIncreasingDigits(int n) {
        
        int[] digits = new int[11];
        int i = 0;
        while (n > 0) {
            digits[i++] = n % 10;
            n /= 10;
        }
        int k = i;
        while (i > 0) {
            if (digits[i - 1] > digits[i]) {
                digits[i - 1]--;
                k = i;
            }
            i--;
        }
        while (k < 10) {
            digits[k++] = 9;
        }
        int ans = 0;
        while (i < 10) {
            ans = ans * 10 + digits[i++];
        }
        return ans;
    }
}