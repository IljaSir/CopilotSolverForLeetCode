class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            int x = s1.charAt(i) - 'a';
            int y = s2.charAt(i) - 'a';
            int rootX = find(parent, x);
            int rootY = find(parent, y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
        char[] res = new char[baseStr.length()];
        for (int i = 0; i < baseStr.length(); i++) {
            int x = baseStr.charAt(i) - 'a';
            res[i] = (char) (find(parent, x) + 'a');
        }
        return new String(res);
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}