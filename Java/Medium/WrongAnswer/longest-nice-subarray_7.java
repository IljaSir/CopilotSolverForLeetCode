class Solution {
    public int longestNiceSubarray(int[] nums) {
        
        int n = nums.length;
        int[] map = new int[1 << 10];
        Arrays.fill(map, -2);
        map[0] = -1;
        int res = 0;
        int mask = 0;
        for (int i = 0; i < n; i++) {
            mask ^= nums[i];
            if (map[mask] == -2) {
                map[mask] = i;
            } else {
                res = Math.max(res, i - map[mask]);
            }
            for (int j = 0; j < 10; j++) {
                int t = mask ^ (1 << j);
                if (map[t] != -2) {
                    res = Math.max(res, i - map[t]);
                }
            }
        }
        return res;
    }
}