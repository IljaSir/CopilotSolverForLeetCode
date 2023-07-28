class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        
        Arrays.sort(banned);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < banned.length; i++) {
            if (sum + banned[i] > maxSum) {
                break;
            }
            sum += banned[i];
            count++;
        }
        int remain = maxSum - sum;
        int maxCount = Math.min(remain / (n - banned.length), n - banned.length);
        return count + maxCount;
    }
}