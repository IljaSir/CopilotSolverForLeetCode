class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int i = 0, j = 0;
        while (i < nums.length) {
            res[j] = nums[i];
            j += 2;
            i++;
        }
        j = 1;
        while (i > 0) {
            res[j] = nums[i-1];
            j += 2;
            i--;
        }
        return res;
    }
}