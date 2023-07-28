class Solution {
    public int[] applyOperations(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[n];
        int i = 0;
        int j = 0;
        while (i < n) {
            if (i == n - 1 || nums[i] != nums[i + 1]) {
                res[j++] = nums[i++];
            } else {
                res[j++] = 2 * nums[i++];
                i++;
            }
        }
        return res;
    }
}