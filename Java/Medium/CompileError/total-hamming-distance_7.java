class Solution {
    public int totalHammingDistance(int[] nums) {
        
        int n = nums.length;
        int ans = 0;
        int[] count = new int[32];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 32; j++) {
                count[j] += (nums[i] >> j) & 1;
            }
        }
        for (int i = 0; i < 32; i++) {
            ans += count[i] * (n - count[i]);
        }
        return ans * (n - c);
        }
        return ans;
    }
}