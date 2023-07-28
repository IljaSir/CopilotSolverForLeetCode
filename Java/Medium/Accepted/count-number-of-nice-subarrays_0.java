class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int[] p = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            p[i + 1] = p[i] + (nums[i] % 2);
        }
        int[] count = new int[n + 1];
        for (int x: p) {
            count[x]++;
        }
        int ans = 0;
        for (int x: p) {
            if (x >= k) {
                ans += count[x - k];
            }
        }
        return ans;
    }
}