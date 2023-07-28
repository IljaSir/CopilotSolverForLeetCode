class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a', parent);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            sb.append((char) (find(parent, baseStr.charAt(i) - 'a') + 'a'));
        }
        return sb.toString();
    }
    
    private void union(int a, int b, int[] parent) {
        int pa = find(parent, a);
        int pb = find(parent, b);
        if (pa != pb) {
            parent[pa] = pb;
        }
    }
    
    private int find(int[] parent, int a) {
        if (parent[a] != a) {
            parent[a] = find(parent, parent[a]);
        }
        return parent[a];
    }
}