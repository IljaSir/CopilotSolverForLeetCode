class Solution {
    public int[][] outerTrees(int[][] trees) {
        
        int n = trees.length;
        if (n <= 1) return trees;
        Arrays.sort(trees, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] p1 = trees[0], p2 = trees[n - 1];
        List<int[]> up = new ArrayList<>(), down = new ArrayList<>();
        up.add(p1);
        down.add(p1);
        for (int i = 1; i < n; i++) {
            if (i == n - 1 || cross(p1, trees[i], p2) > 0) {
                while (up.size() >= 2 && cross(up.get(up.size() - 2), up.get(up.size() - 1), trees[i]) <= 0) {
                    up.remove(up.size() - 1);
                }
                up.add(trees[i]);
            }
            if (i == n - 1 || cross(p1, trees[i], p2) < 0) {
                while (down.size() >= 2 && cross(down.get(down.size() - 2), down.get(down.size() - 1), trees[i]) >= 0) {
                    down.remove(down.size() - 1);
                }
                down.add(trees[i]);
            }
        }
        Set<int[]> set = new HashSet<>(up);
        set.addAll(down);
        int[][] res = new int[set.size()][2];
        int idx = 0;
        for (int[] p : set) {
            res[idx++] = p;
        }
        return res;
    }
}