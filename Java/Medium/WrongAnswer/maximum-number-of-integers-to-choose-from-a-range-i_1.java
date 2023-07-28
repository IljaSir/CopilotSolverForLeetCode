class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        
        Arrays.sort(banned);
        int sum = 0;
        int count = 0;
        int i = 0;
        while (i < banned.length && sum + banned[i] <= maxSum) {
            sum += banned[i];
            i++;
        }
        count = i;
        for (int j = i; j < banned.length; j++) {
            sum += banned[j];
            while (i < banned.length && sum - banned[i] + banned[j] > maxSum) {
                sum -= banned[i];
                i++;
            }
            count = Math.max(count, j - i + 1);
        }
        return Math.min(count + maxSum - sum, n);
    }
}