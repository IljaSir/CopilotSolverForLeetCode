class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        int[] root = new int[26];
        for (int i = 0; i < 26; i++) root[i] = i;
        for (int i = 0; i < s1.length(); i++) {
            int p1 = find(root, s1.charAt(i) - 'a');
            int p2 = find(root, s2.charAt(i) - 'a');
            root[p1] = Math.min(p1, p2);
            root[p2] = Math.min(p1, p2);
        }
        char[] res = new char[baseStr.length()];
        for (int i = 0; i < baseStr.length(); i++) {
            res[i] = (char)(find(root, baseStr.charAt(i) - 'a') + 'a');
        }
        return new String(res);
    }
    private int find(int[] root, int i) {
        while (root[i] != i) {
            root[i] = root[root[i]];
            i = root[i];
        }
        return i;
    }
}