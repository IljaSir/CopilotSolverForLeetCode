class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = (int) Math.abs(sum - goal);
        return (int) Math.ceil((double) diff / limit);
    }
}