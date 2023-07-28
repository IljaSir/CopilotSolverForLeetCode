class Solution {
    public int minOperations(int n) {
        
        int result = 0;
        int target = n;
        while (target > 0) {
            int bit = 0;
            while ((1 << bit) <= target) {
                bit++;
            }
            bit--;
            target -= (1 << bit);
            result++;
        }
        return result;
    }
}