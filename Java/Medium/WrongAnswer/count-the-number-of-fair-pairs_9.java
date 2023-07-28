class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            ans += search(nums, i + 1, n - 1, lower - nums[i]) - search(nums, i + 1, n - 1, upper - nums[i] + 1);
        }
        return ans;
    }

    private int search(int[] nums, int l, int r, int target) {
        int ans = r + 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}