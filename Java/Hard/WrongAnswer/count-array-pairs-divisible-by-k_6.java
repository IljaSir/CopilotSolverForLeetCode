class Solution {
    public long countPairs(int[] nums, int k) {
        
        int[] map = new int[k];
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int mod = nums[i] % k;
            if (mod < 0) {
                mod += k;
            }
            if (mod == 0) {
                res += map[0];
            } else {
                res += map[k - mod];
            }
            map[mod]++;
        }
        return res;
    }
}