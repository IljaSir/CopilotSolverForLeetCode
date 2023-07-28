class Solution {
    public int partitionArray(int[] nums, int k) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            if (max - min > k) {
                min = nums[i];
                max = nums[i];
                ans++;
            }
        }
        return ans;
    }
}