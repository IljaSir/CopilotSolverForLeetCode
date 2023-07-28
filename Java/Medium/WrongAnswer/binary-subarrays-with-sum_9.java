class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int[] sum = new int[nums.length + 1];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 0; i < sum.length; i++) {
            int target = sum[i] + goal;
            int index = Arrays.binarySearch(sum, target);
            if (index >= 0) {
                count += index - i;
            } else {
                count += -index - 1 - i;
            }
        }
        return count;
    }
}