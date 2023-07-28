class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        int[] p = new int[26];
        for (int i = 0; i < 26; i++) {
            p[i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            int x = s1.charAt(i) - 'a';
            int y = s2.charAt(i) - 'a';
            int px = find(p, x);
            int py = find(p, y);
            p[px] = py;
        }
        StringBuilder res = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            res.append((char) ('a' + find(p, c - 'a')));
        }
        return res.toString();
    }
    private int find(int[] p, int x) {
        if (p[x] != x) {
            p[x] = find(p, p[x]);
        }
        return p[x];
    }
}