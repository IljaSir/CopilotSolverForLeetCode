class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        
        int[] result = new int[k];
        int n = nums.length;
        int i = 0;
        for (int num : nums) {
            while (i > 0 && n - i > k - result.length && result[i - 1] > num) {
                i--;
            }
            if (i < k) {
                result[i++] = num;
            } else {
                n--;
            }
        }
        return result;
    }
}