class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[] count = new int[k];
        for (int i = 0; i <= n; i++) {
            count[(sum[i] % k + k) % k]++;
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += count[i] * (count[i] - 1) / 2;
        }
        return ans;
    }
}