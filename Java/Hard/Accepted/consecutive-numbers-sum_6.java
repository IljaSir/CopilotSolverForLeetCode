class Solution {
    public int consecutiveNumbersSum(int n) {
        
        int count = 0;
        for (int i = 1; i * (i - 1) / 2 < n; i++) {
            int target = n - i * (i - 1) / 2;
            if (target % i == 0) {
                count++;
            }
        }
        return count;
    }
}