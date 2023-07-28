class Solution {
    public int smallestRangeII(int[] nums, int k) {
        
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int min = nums[0];
        int ans = max - min;
        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            int high = Math.max(max - k, a + k);
            int low = Math.min(min + k, b - k);
            ans = Math.min(ans, high - low);
        }
        return ans;
    }
}