class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        
        Arrays.sort(nums);
        int mex = 0;
        for (int num : nums) {
            if (num > mex) {
                break;
            }
            mex = num + value;
        }
        return mex min;
    }
}