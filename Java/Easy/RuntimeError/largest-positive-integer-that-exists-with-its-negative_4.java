class Solution {
    public int findMaxK(int[] nums) {
        
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        if (max <= 0) {
            return -1;
        }
        int[] arr = new int[max + 1];
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                arr[nums[i]] = 1;
            }
        }
        for (int i = max; i >= 1; i--) {
            if (arr[i] == 1 && arr[-i] == 1) {
                return i;
            }
        }
        return -1;
    }
}