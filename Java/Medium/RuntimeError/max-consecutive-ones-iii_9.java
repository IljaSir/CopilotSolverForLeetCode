class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int n = nums.length;
        int[] count = new int[n];
        int i = 0;
        int j = 0;
        int max = 0;
        int sum = 0;
        while (j < n) {
            if (nums[j] == 0) {
                count[i] = j - i;
                i = j + 1;
                sum++;
            }
            j++;
            if (sum > k) {
                max = Math.max(max, j - i);
                i += count[i];
                sum--;
            }
        }
        max = Math.max(max, j - i);
        return max;
    }
}