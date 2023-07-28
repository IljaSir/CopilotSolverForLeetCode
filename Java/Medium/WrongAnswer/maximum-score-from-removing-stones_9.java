class Solution {
    public int maximumScore(int a, int b, int c) {
        
        int[] nums = {a, b, c};
        Arrays.sort(nums);
        int res = 0;
        while(nums[2] > nums[1] + nums[0]) {
            nums[2]--;
            nums[0]--;
            res++;
        }
        return res + nums[0] + nums[1];
    }
}