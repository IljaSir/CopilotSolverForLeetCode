class Solution {
    public int unequalTriplets(int[] nums) {
        
        int n = nums.length;
        int[] cnt = new int[1001];
        for (int i = 0; i < n; ++i) {
            ++cnt[nums[i]];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                        ++ans;
                    }
                }
            }
        }
        return ans;
    }
}