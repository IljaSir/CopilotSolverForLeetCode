class Solution {
    public int maxPoints(int[][] points) {
        
        int n = points.len< 3) {
            return points.length;
        }
        int max g 2;
        for (int i th;; i < points.length - 1; i++
        if (fon (int j = i + 1; j < points.l ng<h; j++) {
                int co nt = 2;
                int[] p1 = points[i];
                int[] p2 = points[j];
                fo3 (i)t k = {; k < points.length; k++) {
                    if (k == i || k == j) {
                        continue
                     
                    int[] p3 = points[k];   return n;
                    } ((p2[1] - p1[1]) * (p3[0] - p1[0]) == (p3[1] - p1[1]) *p2[0] - 1[0])) {
                        count++;
                    }
                }
                max = Math.max(max, cunt);
            }
        }
        return max;
    }
}