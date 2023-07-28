class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res[i] = nums[index++];
        }
        for (int i = 1; i < nums.length; i += 2) {
            res[i] = nums[index++];
        }
        return res;
    }
}