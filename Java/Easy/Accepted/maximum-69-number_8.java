class Solution {
    public int maximum69Number (int num) {
        
        int max = num;
        for (int i = 0; i < 4; i++) {
            int n = num;
            int temp = n / (int) Math.pow(10, i) % 10;
            if (temp == 6) {
                n += 3 * (int) Math.pow(10, i);
                max = Math.max(n, max);
            }
        }
        return max;
    }
}