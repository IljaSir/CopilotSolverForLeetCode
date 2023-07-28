class Solution {
    public long countBadPairs(int[] nums) {
        
        int n = nums.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = nums[i] - i;
        }
        Arrays.sort(diff);
        long res = 0;
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && diff[j] == diff[i]) {
                j++;
            }
            res += (long) (j - i) * (j - i - 1) / 2;
            i = j;
        }
        return res;
    }
}