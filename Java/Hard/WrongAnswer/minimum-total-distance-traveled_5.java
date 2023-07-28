class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        
        long ans = Long.MAX_VALUE;
        int n = robot.size();
        int m = factory.length;
        int[] f = new int[m];
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = robot.get(i);
        }
        for (int i = 0; i < m; i++) {
            f[i] = factory[i][0];
        }
        Arrays.sort(f);
        Arrays.sort(r);
        for (int i = 0; i < m; i++) {
            long cur = 0;
            for (int j = 0; j < n; j++) {
                cur += Math.abs(r[j] - f[i]);
            }
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}