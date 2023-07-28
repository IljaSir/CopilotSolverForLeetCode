class Solution {
    public boolean equationsPossible(String[] equations) {
        
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                int x = s.charAt(0) - 'a';
                int y = s.charAt(3) - 'a';
                union(parent, x, y);
            }
        }
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                int x = s.charAt(0) - 'a';
                int y = s.charAt(3) - 'a';
                if (find(parent, x) == find(parent, y)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void union(int[] parent, int i, int j) {
        parent[find(parent, i)] = find(parent, j);
    }
    
    public int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}