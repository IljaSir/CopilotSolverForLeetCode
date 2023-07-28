class Solution {
    public int maximum69Number (int num) {
        
        int max = num;
        int temp = num;
        int count = 0;
        int base = 1;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 6) {
                max = Math.max(max, num + 3 * base);
            }
            base *= 10;
            temp /= 10;
            count++;
        }
        return max;
    }
}