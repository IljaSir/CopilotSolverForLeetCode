class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        
        int[] a = new int[]{p1[0], p1[1]};
        int[] b = new int[]{p2[0], p2[1]};
        int[] c = new int[]{p3[0], p3[1]};
        int[] d = new int[]{p4[0], p4[1]};
        int[][] points = new int[][]{a, b, c, d};
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        int[] x = new int[]{points[0][0], points[1][0], points[2][0], points[3][0]};
        int[] y = new int[]{points[0][1], points[1][1], points[2][1], points[3][1]};
        if (x[0] == x[1] && x[2] == x[3] && y[0] == y[3] && y[1] == y[2] && x[0] != x[2] && y[0] != y[1]) {
            int d1 = (x[0] - x[2]) * (x[0] - x[2]) + (y[0] - y[2]) * (y[0] - y[2]);
            int d2 = (x[1] - x[3]) * (x[1] - x[3]) + (y[1] - y[3]) * (y[1] - y[3]);
            return d1 == d2;
        }
        return false;
    }
}
    }
}