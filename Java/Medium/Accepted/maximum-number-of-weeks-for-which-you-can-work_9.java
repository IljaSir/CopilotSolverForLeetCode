class Solution {
    public long numberOfWeeks(int[] milestones) {
        
        long sum = 0;
        long max = 0;
        for (int x : milestones) {
            sum += x;
            max = Math.max(max, x);
        }
        if (max > sum - max) {
            return 2 * (sum - max) + 1;
        }
        return sum;
    }
}