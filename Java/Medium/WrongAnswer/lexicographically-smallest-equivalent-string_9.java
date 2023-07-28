class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        // Union find
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            int p1 = find(parent, s1.charAt(i) - 'a');
            int p2 = find(parent, s2.charAt(i) - 'a');
            if (p1 != p2) {
                parent[p1] = p2;
            }
        }
        char[] result = new char[baseStr.length()];
        for (int i = 0; i < baseStr.length(); i++) {
            result[i] = (char) (find(parent, baseStr.charAt(i) - 'a') + 'a');
        }
        return new String(result);
    }
    
    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}