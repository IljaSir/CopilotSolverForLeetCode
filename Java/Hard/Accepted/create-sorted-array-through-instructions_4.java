class Solution {
    public int createSortedArray(int[] instructions) {
        
        int mod = 1000000007;
        int[] tree = new int[100001];
        int cost = 0;
        for (int i = 0; i < instructions.length; i++) {
            int val = instructions[i];
            int left = query(tree, val - 1);
            int right = i - query(tree, val);
            cost = (cost + Math.min(left, right)) % mod;
            update(tree, val);
        }
        return cost;
    }
    public int query(int[] tree, int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }
        return sum;
    }
    public void update(int[] tree, int index) {
        while (index < tree.length) {
            tree[index] += 1;
            index += index & -index;
        }
    }
}