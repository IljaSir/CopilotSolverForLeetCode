class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        
        int n = nums.length;
        int[] count = new int[n];
        for (int[] r : requests) {
            count[r[0]]++;
            if (r[1] + 1 < n) {
                count[r[1] + 1]--;
            }
        }
        for (int i = 1; i < n; i++) {
            count[i] += count[i - 1];
        }
        Arrays.sort(count);
        Arrays.sort(nums);
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long) count[i] * nums[i];
        }
        return (int) (res % (1e9 + 7));
    }
}