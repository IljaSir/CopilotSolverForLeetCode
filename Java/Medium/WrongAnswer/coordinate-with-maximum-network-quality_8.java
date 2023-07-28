class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        
        int[] res = new int[2];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < towers.length; i++) {
            int[] tower = towers[i];
            int x1 = tower[0];
            int y1 = tower[1];
            int q1 = tower[2];
            int q = 0;
            for (int j = 0; j < towers.length; j++) {
                int[] tower2 = towers[j];
                int x2 = tower2[0];
                int y2 = tower2[1];
                int q2 = tower2[2];
                double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                if (d <= radius) {
                    q += Math.floor(q2 / (1 + d));
                }
            }
            if (q > max) {
                max = q;
                res[0] = x1;
                res[1] = y1;
            } else if (q == max) {
                if (x1 < res[0]) {
                    res[0] = x1;
                    res[1] = y1;
                } else if (x1 == res[0] && y1 < res[1]) {
                    res[0] = x1;
                    res[1] = y1;
                }
            }
        }
        return res;
    }
}