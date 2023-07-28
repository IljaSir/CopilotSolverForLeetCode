class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        
        long ans = 0;
        int[] bitCount = new int[32];
        for (int n : nums) {
            for (int i = 0; i < 32; i++) {
                if ((n & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }
        for (int n : nums) {
            int bitSum = 0;
            for (int i = 0; i < 32; i++) {
                if ((n & (1 << i)) != 0) {
                    bitSum += bitCount[i];
                } else {
                    bitSum += nums.length - bitCount[i];
                }
            }
            if (bitSum >= k) {
                ans++;
            }
        }
        return ans;
    }
}