class Solution {
    public int maximumCandies(int[] candies, long k) {
        
        int sum = 0;
        int n = candies.length;
        for (int i = 0; i < n; i++) {
            sum += candies[i];
        }
        int[] prefixSum = new int[n];
        prefixSum[0] = candies[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + candies[i];
        }
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (prefixSum[mid] < k) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        long ans = 0;
        if (prefixSum[i] < k) {
            ans = (i + 1) * (k / (i + 1)) + prefixSum[i];
        } else {
            ans = prefixSum[i];
        }
        return (int) Math.min(sum, ans);
    }
}