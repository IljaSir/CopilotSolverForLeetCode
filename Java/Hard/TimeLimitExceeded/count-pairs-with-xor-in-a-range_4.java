class Solution {
    public int countPairs(int[] nums, int low, int high) {
        
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xor = nums[i] ^ nums[j];
                if (xor >= low && xor <= high) {
                    res++;
                }
            }
        }
        return res;
    }
}