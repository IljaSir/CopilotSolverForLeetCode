class Solution {
    public int countLatticePoints(int[][] circles) {
        
        int res = 0;
        for (int i = 0; i < circles.length; i++) {
            int[] c1 = circles[i];
            for (int j = 0; j < circles.length; j++) {
                if (i == j) continue;
                int[] c2 = circles[j];
                int dx = c1[0] - c2[0];
                int dy = c1[1] - c2[1];
                int d = dx * dx + dy * dy;
                int r = c1[2] + c2[2];
                if (d <= r * r) {
                    res += 4;
                }
            }
        }
        return res;
    }
}