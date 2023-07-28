class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        
        int[] cnt = new int[61];
        long res = 0;
        for (int num : nums) {
            cnt[Integer.bitCount(num)]++;
        }
        for (int i = 0; i < 61; i++) {
            for (int j = i; j < 61; j++) {
                if (i + j >= k) {
                    if (i == j) {
                        res += cnt[i] * (cnt[i] - 1L) / 2;
                    }
                    else {
                        res += cnt[i] * cnt[j];
                    }
                }
            }
        }
        return res;
    }
}