class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                if (min >= minK && max <= maxK) {
                    ans++;
                }
            }
        }
        return ans;
    }
}