class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int k = 0;
        while (i < j) {
            result[k++] = nums[i++];
            result[k++] = nums[j--];
        }
        if (i == j) {
            result[k] = nums[i];
        }
        return result;
    }
}