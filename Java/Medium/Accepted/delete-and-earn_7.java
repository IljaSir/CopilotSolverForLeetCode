class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int[] sum = new int[10001];
        for (int num : nums) {
            sum[num] += num;
        }
        int skip = 0;
        int take = 0;
        for (int i = 0; i < sum.length; i++) {
            int takei = skip + sum[i];
            int skipi = Math.max(skip, take);
            skip = skipi;
            take = takei;
        }
        return Math.max(skip, take);
    }
}