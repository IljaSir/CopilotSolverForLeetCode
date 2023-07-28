class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        
        long sum = 0;
        for (int x : nums) {
            sum += x;
        }
        long diff = Math.abs(goal - sum);
        return (int) (diff / limit + (diff % limit == 0 ? 0 : 1));
    }
}