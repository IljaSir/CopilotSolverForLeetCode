class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[n];
        int p = 0;
        int q = n - 1;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                res[i] = nums[p++];
            } else {
                res[i] = nums[q--];
            }
        }
        return res;
    }
}