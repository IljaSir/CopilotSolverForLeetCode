class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int[] sum = new int[10001];
        for (int i : nums) {
            sum[i] += i;
        }
        int avoid = 0, using = 0, prev = -1;
        for (int i = 0; i <= 10000; i++) {
            if (sum[i] > 0) {
                int m = Math.max(avoid, using);
                if (i - 1 != prev) {
                    using = m + sum[i];
                    avoid = m;
                } else {
                    using = avoid + sum[i];
                    avoid = m;
                }
                prev = i;
            }
        }
        return Math.max(avoid, using);
    }
}