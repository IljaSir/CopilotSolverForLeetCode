class Solution {
    public int unequalTriplets(int[] nums) {
        
        int n = nums.length;
        int[] cnt = new int[1001];
        for (int x : nums) {
            cnt[x]++;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] != nums[j]) {
                    ans += (n - j - 1) - (cnt[nums[i]] + cnt[nums[j]] - 2);
                }
            }
        }
        return ans;
    }
}