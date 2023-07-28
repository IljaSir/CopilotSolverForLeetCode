class Solution {
    public int[][] outerTrees(int[][] trees) {
        
        int n = trees.length;
        if (n <= 3) return trees;
        Arrays.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] hull = new int[2 * n][2];
        int k = 0;
        for (int i = 0; i < n; i++) {
            while (k >= 2 && cross(hull[k - 2], hull[k - 1], trees[i]) < 0) {
                k--;
            }
            hull[k++] = trees[i];
        }
        for (int i = n - 2, t = k + 1; i >= 0; i--) {
            while (k >= t && cross(hull[k - 2], hull[k - 1], trees[i]) < 0) {
                k--;
            }
            hull[k++] = trees[i];
        }
        return Arrays.copyOf(hull, k - 1);
    }
}