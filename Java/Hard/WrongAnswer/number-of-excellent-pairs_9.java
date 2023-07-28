class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        
        long result = 0;
        int[] count = new int[31];
        for (int i : nums) {
            int bitCount = 0;
            for (int j = 0; j < 31; j++) {
                if ((i & (1 << j)) > 0) {
                    bitCount++;
                }
            }
            count[bitCount]++;
        }
        for (int i = 1; i <= 30; i++) {
            for (int j = i; j <= 30; j++) {
                if (i + j >= k) {
                    if (i == j) {
                        result += (long) count[i] * (count[i] - 1) / 2;
                    } else {
                        result += (long) count[i] * count[j];
                    }
                }
            }
        }
        return result;
    }
}