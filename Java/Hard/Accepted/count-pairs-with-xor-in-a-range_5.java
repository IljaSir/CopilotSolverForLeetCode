class Solution {
    public int countPairs(int[] nums, int low, int high) {
        
        int n = nums.length;
        int[] cnt = new int[1 << 17];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = low; j <= high; j++) {
                ans += cnt[nums[i] ^ j];
            }
            cnt[nums[i]]++;
        }
        return ans;
    }
}