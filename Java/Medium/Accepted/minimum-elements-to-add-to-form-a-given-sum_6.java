class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        
        long sum = 0;
        for (int n : nums) {
            sum += n;
        }
        sum = Math.abs(goal - sum);
        return (int) (sum / limit + (sum % limit == 0 ? 0 : 1));
    }
}