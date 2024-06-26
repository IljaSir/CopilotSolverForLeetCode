class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int[] odd = new int[n + 2];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                odd[++cnt] = i;
            }
        }
        odd[0] = -1;
        odd[++cnt] = n;
        int ans = 0;
        for (int i = 1; i + k <= cnt; i++) {
            ans += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        return ans;
    }
}