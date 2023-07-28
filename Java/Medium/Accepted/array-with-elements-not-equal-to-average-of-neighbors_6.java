class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int[] res = new int[n];
        int i = 0;
        int j = n - 1;
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