class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        
        int n = robot.size();
        int m = factory.length;
        long ans = 0;
        int[] cnt = new int[m];
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int j = 0; j < m; j++) {
                if (cnt[j] < factory[j][1]) {
                    if (Math.abs(robot.get(i) - factory[j][0]) < min) {
                        min = Math.abs(robot.get(i) - factory[j][0]);
                        minIdx = j;
                    }
                }
            }
            ans += min;
            cnt[minIdx]++;
        }
        return ans;
    }
}