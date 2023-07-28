class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        
        int[] sum = new int[nums.length + 1];
        for (int[] r : requests) {
            sum[r[0]]++;
            sum[r[1] + 1]--;
        }
        for (int i = 1; i < sum.length; i++) {
            sum[i] += sum[i - 1];
        }
        Arrays.sort(sum, 1, sum.length);
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 1; i < sum.length; i++) {
            ans += (long) sum[i] * nums[i - 1];
        }
        return (int) (ans % 1_000_000_007);
    }
}