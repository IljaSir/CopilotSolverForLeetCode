class Solution {
    public int countPairs(int[] nums, int low, int high) {
        
        int n = nums.length;
        int[] cnt = new int[1 << 17];
        for (int num : nums) {
            cnt[num]++;
        }
        for (int i = 0; i < 17; i++) {
            for (int mask = 0; mask < (1 << 17); mask++) {
                if (((mask >> i) & 1) == 1) {
                    cnt[mask ^ (1 << i)] += cnt[mask];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int mask = 0; mask < (1 << 17); mask++) {
                if (low <= (nums[i] ^ mask) && (nums[i] ^ mask) <= high) {
                    res += cnt[mask];
                }
            }
            res -= cnt[nums[i]];
        }
        return res / 2;
    }
}