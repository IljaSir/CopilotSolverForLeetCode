class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int[] res = new int[nums.length];
        int l = 0, r = nums.length - 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                res[i] = nums[l];
                l++;
            } else {
                res[i] = nums[r];
                r--;
            }
        }
        return res;
    }
}