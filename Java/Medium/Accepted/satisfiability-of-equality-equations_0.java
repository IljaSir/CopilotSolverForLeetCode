class Solution {
    public boolean equationsPossible(String[] equations) {
        
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int index1 = equation.charAt(0) - 'a';
                int index2 = equation.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int index1 = find(parent, equation.charAt(0) - 'a');
                int index2 = find(parent, equation.charAt(3) - 'a');
                if (index1 == index2) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }
    
    private int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}