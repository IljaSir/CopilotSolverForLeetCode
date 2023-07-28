class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        
        int n = nums.length;
        int[] freq = new int[n];
        for (int[] r : requests) {
            freq[r[0]]++;
            if (r[1] + 1 < n) {
                freq[r[1] + 1]--;
            }
        }
        for (int i = 1; i < n; i++) {
            freq[i] += freq[i - 1];
        }
        Arrays.sort(freq);
        Arrays.sort(nums);
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long) freq[i] * nums[i];
        }
        return (int) (res % (1e9 + 7));
    }
}