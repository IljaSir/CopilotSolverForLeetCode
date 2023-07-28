class Solution {
    public int[][] outerTrees(int[][] trees) {
        
        if (trees.length <= 1) {
            return trees;
        }
        int n = trees.length;
        int[][] result = new int[n][2];
        int min = 0;
        for (int i = 1; i < n; i++) {
            if (trees[i][0] < trees[min][0]) {
                min = i;
            }
        }
        int p = min;
        int q = 0;
        do {
            result[q++] = trees[p];
            int next = (p + 1) % n;
            for (int i = 0; i < n; i++) {
                if (orientation(trees[p], trees[i], trees[next]) == -1) {
                    next = i;
                }
            }
            p = next;
        } while (p != min);
        return Arrays.copyOf(result, q);
    }
}