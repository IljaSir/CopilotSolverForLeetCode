class Solution {
    public boolean findSubarrays(int[] nums) {
        
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = nums[i - 1] + sums[i - 1];
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (sums[j] - sums[j - i] == sums[i - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}