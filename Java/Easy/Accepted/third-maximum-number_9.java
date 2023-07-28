class Solution {
    public int thirdMax(int[] nums) {
        
        // 1. sort the array
        // 2. find the third max
        // 3. if the third max does not exist, return the max
        int n = nums.length;
        Arrays.sort(nums);
        int i = n - 1;
        int max = nums[i];
        int count = 1;
        while (i > 0 && count < 3) {
            if (nums[i] != nums[i - 1]) {
                count++;
                max = nums[i - 1];
            }
            i--;
        }
        return count == 3 ? max : nums[n - 1];
    }
}