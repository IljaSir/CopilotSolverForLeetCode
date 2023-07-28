class Solution {
    public int longestNiceSubarray(int[] nums) {
        
        int n = nums.length;
        int[] count = new int[26];
        int[] count2 = new int[26];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int v = nums[j] - 'a';
                if (v < 0) {
                    count2[-v]++;
                } else {
                    count[v]++;
                }
                if (Arrays.equals(count, count2)) {
                    res = Math.max(res, j - i + 1);
                }
            }
            Arrays.fill(count, 0);
            Arrays.fill(count2, 0);
        }
        return res;
    }
}