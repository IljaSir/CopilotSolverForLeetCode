class Solution {
    public int wiggleMaxLength(int[] nums) {
        
p

        if (nums.length == 1) {
            return 1;
        }
        int[] diff = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            diff[i - 1] = nums[i] - nums[i - 1];
        }
        int res = 1;
        boolean isUp = diff[0] > 0;
        boolean isDown = diff[0] < 0;
        for (int i = 1; i < diff.length; i++) {
            if (diff[i] > 0 && isDown) {
                res++;
                isUp = true;
                isDown = false;
            } else if (diff[i] < 0 && isUp) {
                res++;
                isUp = false;
                isDown = true;
            }
        }
        return res;
    }
}