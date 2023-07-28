class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int n = nums.length;
        int[] sums = new int[n+1];
        for (int i = 0; i < n; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        int[] counts = new int[k];
        for (int i = 0; i < n+1; i++) {
            counts[(sums[i] % k + k) % k]++;
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += counts[i] * (counts[i] - 1) / 2;
        }
        return ans;
    }
}