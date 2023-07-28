class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        
        int[] bitCounts = new int[32];
        for (int num : nums) {
            bitCounts[Integer.bitCount(num)]++;
        }
        long result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                if (i + j >= k) {
                    result += bitCounts[i] * bitCounts[j];
                }
            }
        }
        return result;
    }
}