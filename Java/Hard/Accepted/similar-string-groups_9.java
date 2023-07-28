class Solution {
    public int numSimilarGroups(String[] strs) {
        
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int len = strs.length;
        int[] group = new int[len];
        for (int i = 0; i < len; i++) {
            group[i] = i;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    union(group, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (group[i] == i) {
                count++;
            }
        }
        return count;
    }
    
    private int find(int[] group, int i) {
        if (group[i] == i) {
            return i;
        }
        return find(group, group[i]);
    }
    
    private void union(int[] group, int i, int j) {
        int pi = find(group, i);
        int pj = find(group, j);
        if (pi != pj) {
            group[pi] = pj;
        }
    }
    
    private boolean isSimilar(String s1, String s2) {
        int len = s1.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        return count == 2 || count == 0;
    }
}