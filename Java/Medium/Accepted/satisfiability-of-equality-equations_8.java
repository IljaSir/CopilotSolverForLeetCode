class Solution {
    public boolean equationsPossible(String[] equations) {
        
        int[] p = new int[26];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int x = equation.charAt(0) - 'a';
                int y = equation.charAt(3) - 'a';
                p[find(p, x)] = find(p, y);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int x = equation.charAt(0) - 'a';
                int y = equation.charAt(3) - 'a';
                if (find(p, x) == find(p, y)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    int find(int[] p, int x) {
        if (p[x] != x) {
            p[x] = find(p, p[x]);
        }
        return p[x];
    }
}