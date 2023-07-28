class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        
        long sum = 0;
        for(int num: nums) {
            sum += num;
        }
        long diff = Math.abs(goal - sum);
        if(diff == 0) {
            return 0;
        }
        return (int) (diff / limit + (diff % limit == 0 ? 0 : 1));
    }
}