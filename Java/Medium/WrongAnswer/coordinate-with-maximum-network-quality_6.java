class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        
        int[] max = new int[3];
        for (int i = 0; i < towers.length; i++) {
            int[] tower = towers[i];
            int x = tower[0], y = tower[1], q = tower[2];
            int q1 = 0;
            for (int j = 0; j < towers.length; j++) {
                if (i == j) {
                    continue;
                }
                int[] tower1 = towers[j];
                int x1 = tower1[0], y1 = tower1[1], q2 = tower1[2];
                double d = Math.sqrt((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y));
                if (d <= radius) {
                    q1 += Math.floor(q2 / (1 + d));
                }
            }
            if (q1 > max[2] || (q1 == max[2] && x < max[0]) || (q1 == max[2] && x == max[0] && y < max[1])) {
                max[0] = x;
                max[1] = y;
                max[2] = q1;
            }
        }
        return new int[] {max[0], max[1]};
    }
}