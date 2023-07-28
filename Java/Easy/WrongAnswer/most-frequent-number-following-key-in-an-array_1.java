class Solution {
    public int mostFrequent(int[] nums, int key) {
        
        int max = 0;
        int maxNum = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                if (nums[i + 1] == nums[i]) {
                    count++;
                } else {
                    if (count > max) {
                        maxNum = nums[i + 1];
                        max = count;
                    }
                    count = 0;
                }
            }
        }
        if (count > max) {
            maxNum = nums[nums.length - 1];
        }
        return maxNum;
    }
}