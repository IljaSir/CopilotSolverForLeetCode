class Solution {
    public int minSwaps(int[] nums) {
        
        int n = nums.length;
        int oneCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                oneCount++;
            }
        }
        int i = 0;
        int j = 0;
        int max = 0;
        while (j < n) {
            if (nums[j] == 1) {
                max++;
            }
            if (j - i + 1 > oneCount) {
                if (nums[i] == 1) {
                    max--;
                }
                i++;
            }
            j++;
        }
        return oneCount - max;
    }
}