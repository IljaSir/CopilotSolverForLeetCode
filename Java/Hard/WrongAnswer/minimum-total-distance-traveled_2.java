class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        
        int n = robot.size();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < factory.length; j++) {
                min = Math.min(min, Math.abs(robot.get(i) - factory[j][0]));
            }
            sum += min;
        }
        return sum;
    }
}