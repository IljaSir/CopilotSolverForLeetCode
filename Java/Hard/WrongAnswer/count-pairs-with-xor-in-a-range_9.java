class Solution {
    public int countPairs(int[] nums, int low, int high) {
        
        int n = nums.length;
        int[] cnt = new int[1 << 17];
        int[] cnt2 = new int[1 << 17];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = nums[i] ^ nums[j];
                if (x >= low && x <= high) {
                    cnt2[x]++;
                }
            }
            cnt[nums[i]]++;
        }
        int ans = 0;
        for (int i = 0; i < (1 << 17); i++) {
            if (cnt2[i] > 0) {
                ans += cnt2[i] * cnt[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] >= low && nums[i] <= high) {
                ans += cnt[nums[i]] - 1;
            }
        }
        return ans / 2;
    }
}