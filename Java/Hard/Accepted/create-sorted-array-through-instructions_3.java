class Solution {
    public int createSortedArray(int[] instructions) {
        
        int res = 0;
        int mod = 1000000007;
        int[] tree = new int[100001];
        for (int i = 0; i < instructions.length; i++) {
            int left = query(tree, instructions[i] - 1);
            int right = i - query(tree, instructions[i]);
            res = (res + Math.min(left, right)) % mod;
            update(tree, instructions[i]);
        }
        return res;
    }
    
    public void update(int[] tree, int index) {
        while (index < tree.length) {
            tree[index]++;
            index += index & -index;
        }
    }
    
    public int query(int[] tree, int index) {
        int res = 0;
        while (index > 0) {
            res += tree[index];
            index -= index & -index;
        }
        return res;
    }
}