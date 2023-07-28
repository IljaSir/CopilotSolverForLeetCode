class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        
        long ans = 0;
        int[] bits = new int[31];
        for (int num : nums) {
            int b = 0;
            while (num > 0) {
                if ((num & 1) == 1) {
                    bits[b]++;
                }
                b++;
                num >>= 1;
            }
        }
        for (int i = 0; i < 31; i++) {
            int val = 1 << i;
            for (int j = i; j < 31; j++) {
                if ((val | (1 << j)) >= k) {
                    ans += (long)bits[i] * bits[j];
                    if (i == j) {
                        ans -= bits[i];
                    }
                }
            }
        }
        return ans / 2;
    }
}