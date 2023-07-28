class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        
        int result = 0;
        Arrays.sort(nums);
        int i = nums.length - 1;
        while (i >= 0) {
            int j = i - 1;
            while (j >= 0 && nums[i] >= nums[j] * 2) {
                j--;
            }
            result += i - j - 1;
            i = j;
        }
        return result;
    }
}