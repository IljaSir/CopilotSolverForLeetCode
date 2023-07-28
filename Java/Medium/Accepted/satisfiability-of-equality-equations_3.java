class Solution {
    public boolean equationsPossible(String[] equations) {
        
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                union(parent, x, y);
            }
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int x = find(parent, eq.charAt(0) - 'a');
                int y = find(parent, eq.charAt(3) - 'a');
                if (x == y) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    
    private void union(int[] parent, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);
        if (px != py) {
            parent[px] = py;
        }
    }
}