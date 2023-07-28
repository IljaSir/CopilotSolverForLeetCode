class Solution {
    public int countElements(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[0] && nums[i] < nums[n - 1]) {
                count++;
            }
        }
        return count;
    }
}