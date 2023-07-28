class Solution {
    public long numberOfWeeks(int[] milestones) {
        
        long sum = 0;
        long max = 0;
        for (int i : milestones) {
            sum += i;
            max = Math.max(max, i);
        }
        return Math.min(sum, 2 * (sum - max) + 1);
    }
}