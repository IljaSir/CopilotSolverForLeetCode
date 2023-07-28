class Solution {
    public int consecutiveNumbersSum(int n) {
        
        int count = 0;
        for (int i = 1; i <= (int) Math.sqrt(2 * n); i++) {
            if ((2 * n) % i == 0) {
                if (i % 2 == 1 && (2 * n) / i % 2 == 1) {
                    count++;
                } else if (i % 2 == 0 && (2 * n) / i % 2 == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}