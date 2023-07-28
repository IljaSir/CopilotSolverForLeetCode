class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        int[] head = new int[]{0, 1};
        int[] position = new int[]{0, 0};
        int max = 0;
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle: obstacles) {
            obstacleSet.add(obstacle[0]+","+obstacle[1]);
        }
        for (int command: commands) {
            if (command == -1) {
                head = new int[]{-head[1], head[0]};
            } else if (command == -2) {
                head = new int[]{head[1], -head[0]};
            } else {
                for (int i = 0; i < command; i++) {
                    int[] nextPosition = new int[]{position[0] + head[0], position[1] + head[1]};
                    if (obstacleSet.contains(nextPosition[0]+","+nextPosition[1])) {
                        break;
                    }
                    position = nextPosition;
                    max = Math.max(max, position[0]*position[0]+position[1]*position[1]);
                }
            }
        }
        return max;
    }
}