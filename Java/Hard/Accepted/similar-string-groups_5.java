class Solution {
    public int numSimilarGroups(String[] strs) {
        
        int n = strs.length;
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    union(parent, rank, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }
    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    private void union(int[] parent, int[] rank, int i, int j) {
        int pi = find(parent, i);
        int pj = find(parent, j);
        if (pi == pj) {
            return;
        }
        if (rank[pi] < rank[pj]) {
            parent[pi] = pj;
        } else if (rank[pi] > rank[pj]) {
            parent[pj] = pi;
        } else {
            parent[pj] = pi;
            rank[pi]++;
        }
    }
    private boolean isSimilar(String s1, String s2) {
        int n = s1.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
            if (count > 2) {
                return false;
            }
        }
        return true;
    }
}