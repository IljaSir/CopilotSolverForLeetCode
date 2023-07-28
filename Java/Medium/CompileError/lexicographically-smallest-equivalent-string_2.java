class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a', parent);
        }
        char[] base = baseStr.toCharArray();
        for (int i = 0; i < base.length; i++) {
            base[i] = (char) (find(base[i] - 'a', parent) + 'a');
        }
        return new String(base);
    }
    private int find(int x, int[] parent) {
        return parent[x] == x ? x : (parent[x] = find(parent[x], parent));
    }
}