class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        
        int[] count = new int[nums.length];
        for (int[] r : requests) {
            count[r[0]]++;
            if (r[1] + 1 < nums.length) {
                count[r[1] + 1]--;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            count[i] += count[i - 1];
        }
        Arrays.sort(nums);
        Arrays.sort(count);
        long res = 0;
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] == 0) {
                break;
            }
            res += (long)count[i] * nums[i];
        }
        return (int)(res % 1000000007);
    }
}