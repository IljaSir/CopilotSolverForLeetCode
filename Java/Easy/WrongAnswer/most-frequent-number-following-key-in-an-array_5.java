class Solution {
    public int mostFrequent(int[] nums, int key) {
        
        int max = 0;
        int maxIndex = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                count = 0;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == nums[i + 1]) {
                        count++;
                    }
                }
                if (count > max) {
                    max = count;
                    maxIndex = i + 1;
                }
            }
        }
        return nums[maxIndex];
    }
}