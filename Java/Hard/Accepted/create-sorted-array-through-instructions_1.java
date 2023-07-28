class Solution {
    public int createSortedArray(int[] instructions) {
        
        int n = instructions.length;
        int mod = 1000000007;
        int[] tree = new int[100001];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int left = query(tree, instructions[i] - 1);
            int right = i - query(tree, instructions[i]);
            ans = (ans + Math.min(left, right)) % mod;
            update(tree, instructions[i]);
        }
        return ans;
    }

    private int query(int[] tree, int i) {
        int ans = 0;
        while (i > 0) {
            ans += tree[i];
            i -= i & -i;
        }
        return ans;
    }

    private void update(int[] tree, int i) {
        while (i < tree.length) {
            tree[i]++;
            i += i & -i;
        }
    }
}