class Solution {
    public int longestNiceSubarray(int[] nums) {
        
        int n = nums.length;
        int[] count = new int[26];
        int[] count1 = new int[26];
        int res = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(count, 0);
            Arrays.fill(count1, 0);
            for (int j = i; j < n; j++) {
                if (nums[j] >= 97) {
                    count1[nums[j] - 97]++;
                } else {
                    count[nums[j] - 65]++;
                }
                if (Arrays.equals(count, count1)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }
}