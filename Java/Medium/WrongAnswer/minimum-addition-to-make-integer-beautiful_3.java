class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        
        int[] digits = new int[20];
        int len = 0;
        while (n > 0) {
            digits[len++] = (int) (n % 10);
            n /= 10;
        }
        long ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            int sum = digits[i];
            int carry = 0;
            for (int j = i - 1; j >= 0; j--) {
                sum += digits[j];
                if (sum > target) {
                    carry++;
                    sum -= 10;
                }
            }
            if (sum > target) {
                carry++;
            }
            ans += carry * Math.pow(10, i);
        }
        return ans;
    }
}