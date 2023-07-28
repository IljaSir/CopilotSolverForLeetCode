class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        
        int n = nums.length;
        int[] count = new int[n];
        for (int[] req : requests) {
            count[req[0]]++;
            if (req[1] + 1 < n) {
                count[req[1] + 1]--;
            }
        }
        for (int i = 1; i < n; i++) {
            count[i] += count[i - 1];
        }
        Arrays.sort(nums);
        Arrays.sort(count);
        long res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (count[i] == 0) {
                break;
            }
            res += (long) count[i] * nums[i];
        }
        return (int) (res % 1000000007);
    }
}