class Solution {
    public int[][] outerTrees(int[][] trees) {
        
        int n = trees.length;
        if (n <= 1) {
            return trees;
        }
        Arrays.sort(trees, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        int[][] hull = new int[n][2];
        int m = 0;
        for (int i = 0; i < n; i++) {
            while (m > 1 && cross(hull[m - 2], hull[m - 1], trees[i]) < 0) {
                m--;
            }
            hull[m++] = trees[i];
        }
        for (int i = n - 2, t = m; i >= 0; i--) {
            while (m > t && cross(hull[m - 2], hull[m - 1], trees[i]) < 0) {
                m--;
            }
            hull[m++] = trees[i];
        }
        if (m > 1) {
            m--;
        }
        int[][] ans = new int[m][2];
        for (int i = 0; i < m; i++) {
            ans[i] = hull[i];
        }
        return ans;
    }
}