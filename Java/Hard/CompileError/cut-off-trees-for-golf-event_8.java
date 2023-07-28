class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        
        int m = forest.size();
        int n = forest.get(0).size();
        int[][] trees = new int[m*n][3];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int h = forest.get(i).get(j);
                if (h > 1) {
                    trees[k][0] = h;
                    trees[k][1] = i;
                    trees[k][2] = j;
                    k++;
                }
            }
        }
        Arrays.sort(trees, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int x = 0, y = 0, ans = 0;
        for (int i = 0; i < k; i++) {
            int d = dist(forest, x, y, trees[i][1], trees[i][2]);
            if (d < 0) return -1;
            ans += d;
            x = trees[i][1];
            y = trees[i][2];
        }
        return ans;
    }
}