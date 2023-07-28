class Solution {
    public void sortColors(int[] nums) {
        
        int p0 = 0, p2 = nums.length - 1, curr = 0;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                swap(nums, curr, p0);
                curr++;
                p0++;
            } else if (nums[curr] == 2) {
                swap(nums, curr, p2);
                p2--;
            } else {
                curr++;
            }
        }
    }
}