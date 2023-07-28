class Solution {
    public int totalHammingDistance(int[] nums) {
        
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] bits = new int[32];
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (nums[i] > 0) {
                bits[j++] += nums[i] & 1;
                nums[i] >>= 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += bits[i] * (n - bits[i]);
        }
        return ans;
    }
}