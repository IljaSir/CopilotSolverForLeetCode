class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        
        Arrays.sort(banned);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < banned.length; i++) {
            if (banned[i] > n) {
                break;
            }
            if (banned[i] - 1 - i > 0) {
                sum += banned[i] - 1 - i;
                res += banned[i] - 1 - i;
            }
            if (sum >= maxSum) {
                return res;
            }
        }
        if (n - banned.length > 0) {
            sum += n - banned.length;
            res += n - banned.length;
        }
        if (sum >= maxSum) {
            return res;
        }
        return res;
    }
}