class Solution {
    public int countLatticePoints(int[][] circles) {
        
        int ans = 0;
        for (int[] c : circles) {
            int x = c[0], y = c[1], r = c[2];
            ans += 4 * r + 1;
            for (int[] c2 : circles) {
                int x2 = c2[0], y2 = c2[1], r2 = c2[2];
                if (x == x2 && y == y2) continue;
                int d = (x - x2) * (x - x2) + (y - y2) * (y - y2);
                if (d > (r + r2) * (r + r2)) continue;
                if (d <= (r - r2) * (r - r2)) {
                    ans -= 4 * r2 + 1;
                } else {
                    double a = Math.acos((d + r * r - r2 * r2) / 2.0 / r / Math.sqrt(d));
                    double b = Math.acos((d + r2 * r2 - r * r) / 2.0 / r2 / Math.sqrt(d));
                    ans -= Math.round(2 * r * a / Math.PI) + Math.round(2 * r2 * b / Math.PI) - 4;
                }
            }
        }
        return ans;
    }
}