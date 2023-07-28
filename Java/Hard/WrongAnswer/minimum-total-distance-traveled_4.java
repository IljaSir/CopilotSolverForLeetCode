class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        
        int n = robot.size();
        int m = factory.length;
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            long sum = 0;
            int[] f = factory[i];
            for (int j = 0; j < n; j++) {
                sum += Math.abs(robot.get(j) - f[0]);
            }
            ans = Math.min(ans, sum * f[1]);
        }
        return ans;
    }
}