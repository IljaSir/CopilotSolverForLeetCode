class Solution {
    public int mostFrequent(int[] nums, int key) {
        
        int max = 0;
        int maxKey = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                count++;
            } else if (count > max) {
                max = count;
                maxKey = nums[i];
                count = 0;
            }
        }
        return maxKey;
    }
}