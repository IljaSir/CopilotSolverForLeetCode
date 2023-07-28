class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        for (int x : nums) sum += x;
        for (int i = 1; i <= n / 2; i++) {
            if ((sum * i) % n == 0) {
                if (backtrack(nums, i, 0, 0, (sum * i) / n)) return true;
            }
        }
        return false;
    }
}