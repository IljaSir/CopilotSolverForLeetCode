class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        int n = nums.length;
        int max = 0;
        while (j < n) {
            while (j < n && nums[i] * 2 > nums[j]) {
                j++;
            }
            max = Math.max(max, j - i);
            i++;
        }
        return max;
    }
}