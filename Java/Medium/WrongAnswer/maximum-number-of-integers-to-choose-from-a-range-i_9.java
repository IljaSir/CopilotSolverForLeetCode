class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        
        Arrays.sort(banned);
        int i = 0;
        int j = 1;
        int sum = 0;
        int ans = 0;
        while (i < banned.length) {
            while (j <= banned[i] && sum + j <= maxSum) {
                sum += j;
                j++;
            }
            ans += j - 1;
            sum -= banned[i];
            i++;
        }
        while (j <= n && sum + j <= maxSum) {
            sum += j;
            j++;
        }
        ans += j - 1;
        return ans;
    }
}