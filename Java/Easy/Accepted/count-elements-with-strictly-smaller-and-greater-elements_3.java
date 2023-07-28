class Solution {
    public int countElements(int[] nums) {
        
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean isSmaller = false;
            boolean isGreater = false;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] < nums[j]) {
                    isGreater = true;
                }
                if (nums[i] > nums[j]) {
                    isSmaller = true;
                }
                if (isGreater && isSmaller) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}