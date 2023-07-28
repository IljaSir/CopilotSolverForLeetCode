class Solution {
    public int numSimilarGroups(String[] strs) {
        
        int n = strs.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) union(parent, i, j);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) res++;
        }
        return res;
    }
    private void union(int[] parent, int i, int j) {
        int x = find(parent, i);
        int y = find(parent, j);
        if (x == y) return;
        parent[x] = y;
    }
    private int find(int[] parent, int i) {
        if (parent[i] != i) parent[i] = find(parent, parent[i]);
        return parent[i];
    }
    private boolean isSimilar(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 2) return false;
        }
        return true;
    }
}