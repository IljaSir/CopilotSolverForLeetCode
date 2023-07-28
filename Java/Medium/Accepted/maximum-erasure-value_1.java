class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int ans = 0;
        int l = 0;
        Set<Integer> set = new HashSet<>();
        for (int r = 0; r < nums.length; r++) {
            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                l++;
            }
            set.add(nums[r]);
            ans = Math.max(ans, sum[r + 1] - sum[l]);
        }
        return ans;
    }
}