class Solution {
    public int numSimilarGroups(String[] strs) {
        
        int n = strs.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }
    
    private boolean isSimilar(String a, String b) {
        int m = a.length();
        int diff = 0;
        for (int i = 0; i < m; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 2 || diff == 0;
    }
}
    }
}