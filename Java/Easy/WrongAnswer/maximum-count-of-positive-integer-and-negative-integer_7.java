class Solution {
    public int maximumCount(int[] nums) {
        
        int i = 0;
        int j = nums.length - 1;
        int count = 0;
        while (i <= j) {
            if (nums[i] < 0 && nums[j] < 0) {
                count++;
                i++;
                j--;
            } else if (nums[i] < 0 && nums[j] > 0) {
                count++;
                i++;
            } else if (nums[i] > 0 && nums[j] > 0) {
                count++;
                j--;
            } else {
                break;
            }
        }
        return count;
    }
}