class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0;
        int j = 0;
        int k = n - 1;
        while (j <= k) {
            if (nums[j] < pivot) {
                ans[i] = nums[j];
                j++;
                i++;
            } else if (nums[j] == pivot) {
                j++;
            } else {
                ans[k] = nums[j];
                k--;
            }
        }
        return ans;
    }
}