class Solution {
    public int[] smallestSubarrays(int[] nums) {
        
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int[] last = new int[31];
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int j = 0; j < 31; j++) {
                if ((x & (1 << j)) != 0) {
                    if (last[j] != -1) {
                        ans[i] = Math.min(ans[i], i - last[j]);
                    }
                    last[j] = i;
                }
            }
        }
        Arrays.fill(last, n);
        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i];
            for (int j = 0; j < 31; j++) {
                if ((x & (1 << j)) != 0) {
                    if (last[j] != n) {
                        ans[i] = Math.min(ans[i], last[j] - i);
                    }
                    last[j] = i;
                }
            }
        }
        return ans;
    }
}