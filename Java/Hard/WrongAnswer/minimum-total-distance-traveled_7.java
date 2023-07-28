class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        
        long res = 0;
        int n = robot.size();
        int m = factory.length;
        int[] repair = new int[m];
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < m; j++) {
                int dist = Math.abs(robot.get(i) - factory[j][0]);
                if (repair[j] < factory[j][1] && dist < min) {
                    min = dist;
                    minIndex = j;
                }
            }
            repair[minIndex]++;
            res += min;
        }
        return res;
    }
}