class Solution {
    public int longestNiceSubarray(int[] nums) {
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] count = new int[26];
            for (int j = i; j < nums.length; j++) {
                int index = nums[j] < 97 ? nums[j] - 65 : nums[j] - 97;
                count[index]++;
                if (count[index] == 2) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
}