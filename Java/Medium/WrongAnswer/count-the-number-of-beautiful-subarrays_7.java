class Solution {
    public long beautifulSubarrays(int[] nums) {
        
        int n = nums.length;
        int[] even = new int[n + 1];
        int[] odd = new int[n + 1];
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                even[cur]++;
            } else {
                odd[cur]++;
                cur++;
            }
        }
        long ans = 0;
        for (int i = 0; i <= cur; i++) {
            ans += (long) even[i] * odd[i];
        }
        return ans;
    }
}