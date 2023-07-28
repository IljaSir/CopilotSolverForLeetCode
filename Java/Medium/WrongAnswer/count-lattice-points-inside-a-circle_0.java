class Solution {
    public int countLatticePoints(int[][] circles) {
        
        int n = circles.length;
        int[] x = new int[n];
        int[] y = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = circles[i][0];
            y[i] = circles[i][1];
            r[i] = circles[i][2];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += 4 * r[i] + 1;
            for (int j = 0; j < i; j++) {
                int dx = x[i] - x[j];
                int dy = y[i] - y[j];
                int d2 = dx * dx + dy * dy;
                int r2 = (r[i] + r[j]) * (r[i] + r[j]);
                if (d2 <= r2) {
                    if (d2 + r[i] * r[i] <= r[j] * r[j]) {
                        ans -= 4 * r[i] + 1;
                    } else if (d2 + r[j] * r[j] <= r[i] * r[i]) {
                        ans -= 4 * r[j] + 1;
                    } else {
                        int d = (int) Math.sqrt(d2);
                        int a = (int) (r[i] * r[i] - r[j] * r[j] + d2) / (2 * d);
                        int b = d - a;
                        int h = (int) Math.sqrt(r[i] * r[i] - a * a);
                        ans -= 4 * (a * b + b * h);
                    }
                }
            }
        }
        return ans;
    }
}