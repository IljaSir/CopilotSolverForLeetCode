class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        
        int count = 0;
        Arrays.sort(banned);
        for (int i = 0; i < banned.length; i++) {
            if (i == 0) {
                if (banned[i] - 1 <= maxSum) {
                    int tmp = Math.min(banned[i] - 1, n);
                    count += tmp;
                    maxSum -= tmp;
                } else {
                    break;
                }
            } else {
                if (banned[i] - banned[i - 1] - 1 <= maxSum) {
                    int tmp = Math.min(banned[i] - banned[i - 1] - 1, n - banned[i - 1]);
                    count += tmp;
                    maxSum -= tmp;
                } else {
                    break;
                }
            }
        }
        if (banned.length == 0) {
            count = Math.min(maxSum, n);
        } else {
            if (n - banned[banned.length - 1] <= maxSum) {
                count += n - banned[banned.length - 1];
            }
        }
        return count;
    }
}