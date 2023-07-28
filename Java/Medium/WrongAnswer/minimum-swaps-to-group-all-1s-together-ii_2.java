class Solution {
    public int minSwaps(int[] nums) {
        
        int n = nums.length;
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                ones++;
            }
        }
        int maxOnes = 0;
        int i = 0;
        int j = 0;
        int swaps = 0;
        while (j < n) {
            if (nums[j] == 1) {
                swaps++;
            }
            if (j - i + 1 == ones) {
                maxOnes = Math.max(maxOnes, swaps);
                if (nums[i] == 1) {
                    swaps--;
                }
                i++;
            }
            j++;
        }
        return ones - maxOnes;
    }
}