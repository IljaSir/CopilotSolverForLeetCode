class Solution {
    public int minSwaps(int[] nums) {
        
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            }
        }
        int i = 0;
        int j = 0;
        int maxOnes = 0;
        while (j < n) {
            if (nums[j] == 1) {
                maxOnes++;
            }
            if (j - i + 1 < count) {
                j++;
            } else if (j - i + 1 == count) {
                maxOnes = Math.max(maxOnes, j - i + 1);
                j++;
                i++;
            }
        }
        return count - maxOnes;
    }
}