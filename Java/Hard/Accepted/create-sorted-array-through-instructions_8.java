class Solution {
    public int createSortedArray(int[] instructions) {
        
        int n = instructions.length;
        int[] bit = new int[100001];
        int cost = 0;
        for (int i = 0; i < n; i++) {
            int smaller = query(bit, instructions[i] - 1);
            int larger = i - query(bit, instructions[i]);
            cost += Math.min(smaller, larger);
            cost %= 1000000007;
            update(bit, instructions[i]);
        }
        return cost;
    }
    private void update(int[] bit, int i) {
        while (i < bit.length) {
            bit[i]++;
            i += i & -i;
        }
    }
    private int query(int[] bit, int i) {
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= i & -i;
        }
        return sum;
    }
}