class Solution {
    public int waysToSplit(int[] nums) {
        
        int mod = 1000000007;
        int n = nums.length;
        int[] preSum = new int[n+1];
        for(int i=1; i<=n; i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        int ans = 0;
        int j = 2;
        int k = 2;
        for(int i=1; i<n-1; i++){
            // 0 - i-1
            // i - j-1
            // j - n-1
            // i-1 < j-1 < n-1
            // preSum[j] - preSum[i] >= preSum[i]
            // preSum[n] - preSum[j] >= preSum[j] - preSum[i]
            // preSum[n] - preSum[j] >= preSum[i]
            // preSum[n] - preSum[j] + preSum[i] >= 2 * preSum[i]
            // preSum[n] + preSum[i] >= 2 * preSum[i] + preSum[j]
            // preSum[n] >= 2 * preSum[i] + preSum[j]
            while(j<n && preSum[n] >= 2*preSum[i] + preSum[j]){
                j++;
            }
            // j-1 is the largest index where sum(i, j-1) >= sum(0, i-1)
            // k <= j-1
            k = Math.max(k, i+1);
            while(k<j && preSum[j] - preSum[k] >= preSum[k]){
                k++;
            }
            // k is the smallest index where sum(k, j-1) >= sum(i, k-1)
            // k-1 is the largest index where sum(k-1, j-1) < sum(i, k-1)
            ans = (ans + j-k) % mod;
        }
        return ans;
    }
}