class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int k = 0;
        while (i <= j) {
            res[k++] = nums[i++];
            if (i <= j) {
                res[k++] = nums[j--];
            }
        }
        return res;
    }
}