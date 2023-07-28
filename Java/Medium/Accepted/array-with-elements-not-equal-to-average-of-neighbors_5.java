class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int[] res = new int[n];
        int i = 0;
        int j = n - 1;
        int k = 0;
        while (i < j) {
            res[k++] = nums[i++];
            res[k++] = nums[j--];
        }
        if (i == j) {
            res[k] = nums[i];
        }
        return res;
    }
}