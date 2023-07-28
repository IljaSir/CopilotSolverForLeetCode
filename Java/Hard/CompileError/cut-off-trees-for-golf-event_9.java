class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        
        int m = forest.size();
        int n = forest.get(0).size();
        int[][] trees = new int[m*n][3];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int height = forest.get(i).get(j);
                if (height > 1) {
                    trees[k][0] = height;
                    trees[k][1] = i;
                    trees[k][2] = j;
                    k++;
                }
            }
        }
        Arrays.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));
        int res = 0, sr = 0, sc = 0;
        for (int i = 0; i < k; i++) {
            int d = dist(forest, sr, sc, trees[i][1], trees[i][2]);
            if (d < 0) return -1;
            res += d;
            sr = trees[i][1];
            sc = trees[i][2];
        }
        return res;
    }
}