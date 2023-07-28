class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (nums[i] < 0) {
                    continue;
                }
                for (int j = i + 1; j < n; j++) {
                    if (nums[j] < 0) {
                        swap(nums, i, j);
                        break;
                    }
                }
            } else {
                if (nums[i] > 0) {
                    continue;
                }
                for (int j = i + 1; j < n; j++) {
                    if (nums[j] > 0) {
                        swap(nums, i, j);
                        break;
                    }
                }
            }
        }
        return nums;
    }
}