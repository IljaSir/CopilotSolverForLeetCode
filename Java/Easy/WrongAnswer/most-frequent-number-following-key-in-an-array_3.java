class Solution {
    public int mostFrequent(int[] nums, int key) {
        
        int count = 0;
        int maxCount = 0;
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                count = 0;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == nums[i]) {
                        count++;
                        if (count > maxCount) {
                            maxCount = count;
                            maxNum = nums[j];
                        }
                    }
                }
            }
        }
        return maxNum;
    }
}