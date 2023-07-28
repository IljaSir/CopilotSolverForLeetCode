class Solution {
    public int createSortedArray(int[] instructions) {
        
        int[] bit = new int[100001];
        int MOD = 1000000007;
        int res = 0;
        for (int i = 0; i < instructions.length; i++) {
            int cost = Math.min(get(bit, instructions[i] - 1), i - get(bit, instructions[i]));
            res = (res + cost) % MOD;
            update(bit, instructions[i]);
        }
        return res;
    }
    
    private int get(int[] bit, int i) {
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= lowbit(i);
        }
        return sum;
    }
    
    private void update(int[] bit, int i) {
        while (i < bit.length) {
            bit[i] += 1;
            i += lowbit(i);
        }
    }
}