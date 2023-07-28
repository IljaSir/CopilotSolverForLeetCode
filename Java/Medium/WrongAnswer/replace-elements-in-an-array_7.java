class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        
        int[] res = new int[nums.length];
        for (int i = 0; i < operations.length; i++) {
            int idx = Arrays.binarySearch(nums, operations[i][0]);
            if (idx >= 0) {
                nums[idx] = operations[i][1];
            }
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        return res;
    }
}