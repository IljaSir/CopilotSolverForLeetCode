class Solution {
    public int[][] outerTrees(int[][] trees) {
        
        int n = trees.length;
        if (n <= 1) return trees;
        // find the leftmost point
        int leftmost = 0;
        for (int i = 1; i < n; i++) {
            if (trees[i][0] < trees[leftmost][0]) {
                leftmost = i;
            }
        }
        // sort the points by polar angle
        int[] p = trees[leftmost];
        Arrays.sort(trees, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (int) (getPolarAngle(p, a) - getPolarAngle(p, b));
            }
        });
        // find the convex hull
        List<int[]> hull = new ArrayList<>();
        hull.add(trees[0]);
        hull.add(trees[1]);
        for (int i = 2; i < n; i++) {
            int[] top = hull.get(hull.size() - 1);
            int[] nextTop = hull.get(hull.size() - 2);
            while (getPolarAngle(nextTop, top) > getPolarAngle(top, trees[i])) {
                hull.remove(top);
                top = hull.get(hull.size() - 1);
                nextTop = hull.get(hull.size() - 2);
            }
            hull.add(trees[i]);
        }
        // convert to array
        int[][] res = new int[hull.size()][2];
        for (int i = 0; i < hull.size(); i++) {
            res[i] = hull.get(i);
        }
        return res;
    }
    private double getPolarAngle(int[] p, int[] q) {
        double dx = q[0] - p[0];
        double dy = q[1] - p[1];
        if (dx == 0) {
            return dy > 0 ? Double.MAX_VALUE : Double.MIN_VALUE;
        } else {
            return dy / dx;
        }
    }
}