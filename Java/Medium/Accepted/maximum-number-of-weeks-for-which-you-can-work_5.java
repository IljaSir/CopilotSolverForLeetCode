class Solution {
    public long numberOfWeeks(int[] milestones) {
        
        long max = 0;
        long sum = 0;
        for (int i = 0; i < milestones.length; i++) {
            max = Math.max(max, milestones[i]);
            sum += milestones[i];
        }
        long remain = sum - max;
        return remain >= max ? sum : remain * 2 + 1;
    }
}