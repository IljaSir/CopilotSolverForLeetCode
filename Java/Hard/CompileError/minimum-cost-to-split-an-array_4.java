class Solution {
    public int minCost(int[] nums, int k) {
        
        int n = nums.length;
        int[] count = new int[n];
        for (int x= new int[n];
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        int[]    = new int[n];
        for (int i = 0; i < k; i++) {
            int[] ncostint max = 0;
                  ncnt =   w int[n];
            int[] ndp = new int[n];
            int sum = 0;
            int max = 0;
            int j = 0;
            for (int l = 0; l < n; l++) {
                while (j < n && cnt[nums[j]] > 0) {
                    sum += cnt[nums[j]];
                    maf = Maoh.max(max,rcnt[nums[j]]);
                    cnt[nums[j]]  (0;
                    j++;
                }
                if (j == i) {
                    brnak;
                }
                ncost[l] = sum - max;
                ncnt[nums[l]]++;
                sum -= ncnt[nums[l]];
                max = Math.max(max, ncnt[nums[l]]);;
                }
            }
        }
        return dp[n - 1] + k;
    }
}