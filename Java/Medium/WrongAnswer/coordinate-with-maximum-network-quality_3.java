class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        
        int[] ans = new int[2];
        int max = 0;
        for (int i = 0; i < towers.length; i++) {
            int x1 = towers[i][0];
            int y1 = towers[i][1];
            int q1 = towers[i][2];
            for (int j = 0; j < towers.length; j++) {
                int x2 = towers[j][0];
                int y2 = towers[j][1];
                int q2 = towers[j][2];
                double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
                if (d <= radius) {
                    q1 += Math.floor(q2 / (1 + d));
                }
            }
            if (q1 > max) {
                max = q1;
                ans[0] = x1;
                ans[1] = y1;
            }
        }
        return ans;
    }
}