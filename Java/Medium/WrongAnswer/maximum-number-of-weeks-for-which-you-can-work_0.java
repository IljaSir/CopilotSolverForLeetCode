class Solution {
    public long numberOfWeeks(int[] milestones) {
        
        long sum = 0;
        long max = 0;
        for (int i = 0; i < milestones.length; i++) {
            sum += milestones[i];
            max = Math.max(max, milestones[i]);
        }
        if (sum - max < max) {
            return sum - max;
        }
        return 2 * (sum - max) + 1;
    }
}