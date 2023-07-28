class Solution {
    public int dominantIndex(int[] nums) {
        
        int largest = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
                index = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != largest && largest < 2 * nums[i]) {
                return -1;
            }
        }
        return index;
    }
}