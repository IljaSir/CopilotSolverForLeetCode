class Solution {
    public long numberOfWeeks(int[] milestones) {
        
        long max = 0;
        long sum = 0;
        for (int i = 0; i < milestones.length; i++) {
            max = Math.max(max, milestones[i]);
            sum += milestones[i];
        }
        return Math.min(sum, (max << 1) - 1);
    }
}