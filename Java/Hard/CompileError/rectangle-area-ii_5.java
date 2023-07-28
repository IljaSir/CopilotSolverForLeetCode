class Solution {
    public int rectangleArea(int[][] rectangles) {
        
        int MOD = 1_000_000_007;
        long ans = 0;
        int N = rectangles.length;
        int[] xs = new int[N * 2];
        int t = 0;
        for (int[] rec: rectangles) {
            xs[t++] = rec[0];
            xs[t++] = rec[2];
        }
        Arrays.sort(xs);
        // System.out.println(Arrays.toString(xs));
        SegmentTree st = new SegmentTree(xs);
        // System.out.println(Arrays.toString(st.xs));
        // System.out.println(Arrays.toString(st.tree));
        Arrays.sort(rectangles, new Comparator<int[]>() {
            public int compare(int[] rec1, int[] rec2) {
                return rec1[1] - rec2[1];
            }
        });
        for (int i = 0; i < N; i++) {
            int x1 = rectangles[i][0], y1 = rectangles[i][1];
            int x2 = rectangles[i][2], y2 = rectangles[i][3];
            st.update(x1, x2, 1);
            ans += (long) st.query() * (y2 - y1);
            ans %= MOD;
            for (int j = i + 1; j < N; j++) {
                if (rectangles[j][1] >= y2) break;
                x1 = Math.max(x1, rectangles[j][0]);
                x2 = Math.min(x2, rectangles[j][2]);
                if (x1 < x2) {
                    st.update(x1, x2, 1);
                    ans += (long) st.query() * (Math.min(rectangles[j][3], y2) - y2);
                    ans %= MOD;
                }
            }
            st.update(x1, x2, -1);
        }
        return (int) ans;
    }
}
    }
}