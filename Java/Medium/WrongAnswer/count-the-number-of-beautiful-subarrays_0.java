class Solution {
    public long beautifulSubarrays(int[] nums) {
        
        int n = nums.length;
        int[] odd = new int[n + 2];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                odd[++cnt] = i;
            }
        }
        odd[0] = -1;
        odd[cnt + 1] = n;
        long ans = 0;
        for (int i = 1; i <= cnt; i++) {
            ans += (long) (odd[i] - odd[i - 1]) * (odd[i + 1] - odd[i]);
        }
        return ans;
    }
}