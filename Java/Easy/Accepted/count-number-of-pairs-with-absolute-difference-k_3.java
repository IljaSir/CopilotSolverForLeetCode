class Solution {
    public int countKDifference(int[] nums, int k) {
        
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        int res = 0;
        for (int i = 1; i <= 100; i++) {
            if (i + k <= 100) {
                res += count[i] * count[i + k];
            }
        }
        return res;
    }
}