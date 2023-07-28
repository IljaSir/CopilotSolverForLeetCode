class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int size = nums.length;
        int[] result = new int[size];
        int i = 0;
        int j = size - 1;
        int k = 0;
        Arrays.sort(nums);
        while (i < j) {
            result[k++] = nums[j--];
            result[k++] = nums[i++];
        }
        if (i == j) {
            result[k] = nums[i];
        }
        return result;
    }
}