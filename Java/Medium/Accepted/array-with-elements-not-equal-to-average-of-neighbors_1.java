class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        for (int k = 0; k < nums.length; k++) {
            if (k % 2 == 0) {
                result[k] = nums[i];
                i++;
            } else {
                result[k] = nums[j];
                j--;
            }
        }
        return result;
    }
}