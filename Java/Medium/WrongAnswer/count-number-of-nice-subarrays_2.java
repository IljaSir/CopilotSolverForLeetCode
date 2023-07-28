class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int[] odd = new int[n + 2];
        int t = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                odd[++t] = i;
            }
        }
        odd[0] = -1;
        odd[t + 1] = n;
        int ans = 0;
        for (int i = 1; i + k <= t; i++) {
            ans += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        return ans;
    }
}