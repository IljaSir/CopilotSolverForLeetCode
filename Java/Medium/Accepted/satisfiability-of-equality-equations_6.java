class Solution {
    public boolean equationsPossible(String[] equations) {
        
        int[] parent = new int[26];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                union(parent, equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                if (find(parent, equation.charAt(0) - 'a') == find(parent, equation.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    
    private void union(int[] parent, int i, int j) {
        int parentI = find(parent, i);
        int parentJ = find(parent, j);
        if (parentI != parentJ) {
            parent[parentI] = parentJ;
        }
    }
}