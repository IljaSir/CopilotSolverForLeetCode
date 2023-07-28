class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        
        int n = robot.size(), m = factory.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                min = Math.min(min, Math.abs(robot.get(i) - factory[j][0]) * factory[j][1]);
            }
            ans += min;
        }
        return ans;
    }
}