class Solution {
    public int countTriplets(int[] nums) {
        
        int[] bitCount = new int[1 << 16];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bitCount[nums[i] & nums[j]]++;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << 16); j++) {
                if ((nums[i] & j) == 0) {
                    res += bitCount[j];
                }
            }
        }
        return res;
    }
}