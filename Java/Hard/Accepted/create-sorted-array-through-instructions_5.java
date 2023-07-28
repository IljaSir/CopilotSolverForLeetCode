class Solution {
    public int createSortedArray(int[] instructions) {
        
        int mod = (int)1e9+7;
        int n = instructions.length;
        int[] bit = new int[100001];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cost = Math.min(get(bit, instructions[i] - 1), i - get(bit, instructions[i]));
            res = (res + cost) % mod;
            update(bit, instructions[i], 1);
        }
        return res;
    }
    private void update(int[] bit, int x, int val) {
        for (int i = x; i < bit.length; i += i & -i) {
            bit[i] += val;
        }
    }
    private int get(int[] bit, int x) {
        int res = 0;
        for (int i = x; i > 0; i -= i & -i) {
            res += bit[i];
        }
        return res;
    }
}