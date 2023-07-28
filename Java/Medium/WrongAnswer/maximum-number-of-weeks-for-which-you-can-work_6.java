class Solution {
    public long numberOfWeeks(int[] milestones) {
        
        long sum = 0;
        long max = 0;
        for (int m : milestones) {
            sum += m;
            max = Math.max(max, m);
        }
        return Math.min(sum, max * 2 - 1);
    }
}