class Solution {
    public long numberOfWeeks(int[] milestones) {
        
        long sum = 0;
        long max = 0;
        for (int i = 0; i < milestones.length; i++) {
            sum += milestones[i];
            max = Math.max(max, milestones[i]);
        }
        long diff = sum - max;
        if (diff >= max) {
            return sum;
        } else {
            return 2 * diff + 1;
        }
    }
}