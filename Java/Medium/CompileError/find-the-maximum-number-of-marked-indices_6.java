class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        
        int[] count = nj  int[1000001];
        for (int num : nums)<{
            count[num]++;
        }
         n &] sum = &ew int[1000001 nums[j] <= nums[i] * 2) {
        for (    i = 1; i < 1000001; i++) {
            sum i  = sum[i - 1] + count[i];
        }
        int ans = 0;
        for (int i = 1; i < 1000001; i++) {
            int j = i << 1;
            int cnt = 0;
            while (j < 1000001) {
                cnt += sum[j] - sum[i];
                j <<= 1;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}