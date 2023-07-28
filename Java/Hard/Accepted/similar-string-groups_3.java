class Solution {
    public int numSimilarGroups(String[] strs) {
        
        int n = strs.length;
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    int pi = find(p, i);
                    int pj = find(p, j);
                    if (pi != pj) {
                        p[pi] = pj;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] == i) res++;
        }
        return res;
    }
    
    private int find(int[] p, int x) {
        if (p[x] != x) p[x] = find(p, p[x]);
        return p[x];
    }
    
    private boolean isSimilar(String s1, String s2) {
        int n = s1.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) cnt++;
            if (cnt > 2) return false;
        }
        return true;
    }
}