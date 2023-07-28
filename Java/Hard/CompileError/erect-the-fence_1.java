class Solution {
    public int[][] outerTrees(int[][] trees) {
        
        int n = trees.length;
        if (n <= 3) return trees;
        Arrays.sort(trees, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] p1 = trees[0], p2 = trees[n - 1];
        Set<int[]> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        int[][] s1 = new int[n][2];
        int[][] s2 = new int[n][2];
        int i1 = 0, i2 = 0;
        for (int[] p : trees) {
            if (p == p1 || p == p2) continue;
            while (i1 > 0 && ccw(p1, p, s1[i1 - 1]) > 0) i1--;
            s1[i1++] = p;
            while (i2 > 0 && ccw(p2, p, s2[i2 - 1]) < 0) i2--;
            s2[i2++] = p;
        }
        for (int i = 0; i < i1; i++) set.add(s1[i]);
        for (int i = 0; i < i2; i++) set.add(s2[i]);
        return set.toArray(new int[set.size()][]);
    }
}