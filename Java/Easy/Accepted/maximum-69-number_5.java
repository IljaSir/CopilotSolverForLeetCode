class Solution {
    public int maximum69Number (int num) {
        
        int max = num;
        for (int i = 1; i <= num; i *= 10) {
            int n = num / i % 10;
            if (n == 6) {
                max = Math.max(max, num + 3 * i);
            }
        }
        return max;
    }
}