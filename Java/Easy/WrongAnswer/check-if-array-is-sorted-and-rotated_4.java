class Solution {
    public boolean check(int[] nums) {
        
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}