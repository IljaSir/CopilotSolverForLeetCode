class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int[] result = new int[nums.length];
        Arrays.sort(nums);
        int mid = nums.length / 2;
        int i = 0;
        int j = mid;
        int k = 0;
        while (i < mid && j < nums.length) {
            result[k++] = nums[i++];
            result[k++] = nums[j++];
        }
        while (i < mid) {
            result[k++] = nums[i++];
        }
        while (j < nums.length) {
            result[k++] = nums[j++];
        }
        return result;
    }
}