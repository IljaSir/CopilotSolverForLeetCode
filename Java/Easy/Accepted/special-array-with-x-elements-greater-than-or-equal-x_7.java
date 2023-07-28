class Solution {
    public int specialArray(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (x >= n - i && (i == 0 || nums[i - 1] < n - i)) {
                return n - i;
            }
        }
        return -1;
    }
}