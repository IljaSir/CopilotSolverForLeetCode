class Solution {
    public int countPairs(int[] nums, int low, int high) {
        
        int n = nums.length;
        int[] freq = new int[1 << 16];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = low; j <= high; j++) {
                ans += freq[nums[i] ^ j];
            }
            freq[nums[i]]++;
        }
        return ans;
    }
}