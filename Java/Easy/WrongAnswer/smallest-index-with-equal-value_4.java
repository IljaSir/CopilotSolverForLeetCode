class Solution {
    public int smallestEqual(int[] nums) {
        
        int[] count = new int[10];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (count[nums[i]] == 1 && nums[i] == i % 10) {
                res = Math.min(res, i);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}