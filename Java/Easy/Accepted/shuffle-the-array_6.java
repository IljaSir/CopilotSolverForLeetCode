class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int[] result = new int[2*n];
        int i = 0;
        for (int j = 0; j < n; j++) {
            result[i++] = nums[j];
            result[i++] = nums[j+n];
        }
        return result;
    }
}