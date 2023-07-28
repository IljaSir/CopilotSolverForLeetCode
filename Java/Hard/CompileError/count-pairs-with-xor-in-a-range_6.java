class Solution {
    public int countPairs(int[] nums, int low, int high) {
        
        int n = nums.length, res = 0;
        int[] cnt = new int[1 << 17];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xor = nums[i] ^ nums[j];
                if (xor >= low && xor <= high) {
                    res++;
                }
            }
            cnt[nums[i]]++;
        }
        for (int i = 0; i < 1 << 17; i++) {
            for (int j = i + 1; j < 1 << 17; j++) {
                if (i ^ j >= low && i ^ j <= high) {
                    res += cnt[i] * cnt[j];
                }
            }
        }
        return res;
    }
}