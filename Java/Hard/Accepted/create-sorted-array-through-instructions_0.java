class Solution {
    public int createSortedArray(int[] instructions) {
        
        int[] bit = new int[100001];
        int cost = 0;
        for (int i = 0; i < instructions.length; i++) {
            cost += Math.min(get(bit, instructions[i] - 1), i - get(bit, instructions[i]));
            cost %= 1000000007;
            update(bit, instructions[i], 1);
        }
        return cost;
    }
    
    private void update(int[] bit, int i, int val) {
        while (i < bit.length) {
            bit[i] += val;
            i += i & -i;
        }
    }
    
    private int get(int[] bit, int i) {
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= i & -i;
        }
        return sum;
    }
}