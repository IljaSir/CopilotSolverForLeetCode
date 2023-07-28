class Solution {
    public int mostFrequent(int[] nums, int key) {
        
        int max = 0;
        int maxEle = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                int count = 0;
                int j = i + 1;
                while (j < nums.length && nums[j] == nums[i + 1]) {
                    count++;
                    j++;
                }
                if (count > max) {
                    max = count;
                    maxEle = nums[i + 1];
                }
            }
        }
        return maxEle;
    }
}