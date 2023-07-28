class Solution {
    public int firstMissingPositive(int[] nums) {
        
        // 1 <= nums.length <= 10^5
        // -2^31 <= nums[i] <= 2^31 - 1
        int[] arr = new int[100000];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) continue;
            arr[nums[i]] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) return i;
        }
        return 1;
    }
}