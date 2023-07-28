class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        int n = nums.length;
        int res = 0;
        Map<Integer, Integer>[] maps = new Map[n];
        for (int i = 0; i < n; i++) {
            maps[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }
                int d = (int) diff;
                int c1 = maps[i].getOrDefault(d, 0);
                int c2 = maps[j].getOrDefault(d, 0);
                res += c2;
                maps[i].put(d, c1 + c2 + 1);
            }
        }
        return res;
    }
}