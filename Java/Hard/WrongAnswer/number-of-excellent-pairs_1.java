class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        
        long ans = 0;
        int[] cnt = new int[60];
        for (int num : nums) {
            for (int i = 0; i < 60; i++) {
                if ((num & (1 << i)) != 0) {
                    cnt[i]++;
                }
            }
        }
        for (int num : nums) {
            long cnt1 = 0;
            long cnt2 = 0;
            for (int i = 0; i < 60; i++) {
                if ((num & (1 << i)) != 0) {
                    cnt1 += cnt[i];
                } else {
                    cnt2 += cnt[i];
                }
            }
            ans += cnt1 * cnt2;
        }
        ans /= 2;
        for (int num : nums) {
            int bits = 0;
            for (int i = 0; i < 60; i++) {
                if ((num & (1 << i)) != 0) {
                    bits++;
                }
            }
            if (bits >= k) {
                ans++;
            }
        }
        return ans;
    }
}