class Solution {
    public int createSortedArray(int[] instructions) {
        
        int mod = 1000000007;
        int max = 100001;
        int[] tree = new int[max];
        int res = 0;
        for (int i = 0; i < instructions.length; i++) {
            int left = query(tree, instructions[i] - 1);
            int right = i - query(tree, instructions[i]);
            res = (res + Math.min(left, right)) % mod;
            update(tree, instructions[i]);
        }
        return res;
    }
    
    public int query(int[] tree, int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & (-i);
        }
        return sum;
    }
    
    public void update(int[] tree, int i) {
        while (i < tree.length) {
            tree[i]++;
            i += i & (-i);
        }
    }
}