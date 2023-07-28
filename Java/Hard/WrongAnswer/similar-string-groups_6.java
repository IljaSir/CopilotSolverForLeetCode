class Solution {
    public int numSimilarGroups(String[] strs) {
        
        int n = strs.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; ++i) parent[i] = i;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (isSimilar(strs[i], strs[j])) {
                    int x = find(parent, i);
                    int y = find(parent, j);
                    if (x != y) {
                        parent[x] = y;
                        --n;
                    }
                }
            }
        }
        return n;
    }

    private boolean isSimilar(String s1, String s2) {
        int n = s1.length();
        int diff = 0;
        for (int i = 0; i < n; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++diff;
                if (diff > 2) return false;
            }
        }
        return true;
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}