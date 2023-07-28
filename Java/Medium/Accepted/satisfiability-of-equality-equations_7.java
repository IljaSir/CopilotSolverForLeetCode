class Solution {
    public boolean equationsPossible(String[] equations) {
        
        int[] parents = new int[26];
        for (int i = 0; i < 26; i++) {
            parents[i] = i;
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                union(parents, x, y);
            }
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                if (find(parents, x) == find(parents, y)) {
                    return false;
                }
            }
        }
        return true;
    }
    public void union(int[] parents, int x, int y) {
        parents[find(parents, x)] = find(parents, y);
    }
    public int find(int[] parents, int x) {
        if (parents[x] != x) {
            parents[x] = find(parents, parents[x]);
        }
        return parents[x];
    }
}