class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int max = 0;
        for (int n: nums) {
            max = Math.max(max, n);
        }
        int[] sum = new int[max+1];
        for (int n: nums) {
            sum[n] += n;
        }
        int take = 0, skip = 0;
        for (int n: sum) {
            int takei = skip + n;
            int skipi = Math.max(skip, take);
            take = takei;
            skip = skipi;
        }
        return Math.max(take, skip);
    }
}