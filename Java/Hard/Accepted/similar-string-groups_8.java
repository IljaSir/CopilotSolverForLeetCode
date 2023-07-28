class Solution {
    public int numSimilarGroups(String[] strs) {
        
        int n = strs.length;
        int[] parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(isSimilar(strs[i], strs[j])) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for(int i=0; i<n; i++) {
            if(parent[i] == i) {
                count++;
            }
        }
        return count;
    }
    
    private boolean isSimilar(String str1, String str2) {
        int count = 0;
        for(int i=0; i<str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }
        return count == 2 || count == 0;
    }
    
    private int find(int[] parent, int i) {
        if(parent[i] == i) {
            return i;
        }
        return find(parent, parent[i]);
    }
    
    private void union(int[] parent, int i, int j) {
        int x = find(parent, i);
        int y = find(parent, j);
        if(x != y) {
            parent[x] = y;
        }
    }
}