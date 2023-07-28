class Solution {
    public int captureForts(int[] forts) {
        
        int n = forts.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 1) {
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 0) {
                sum++;
            }
            left[i] = sum;
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (forts[i] == 0) {
                sum++;
            }
            right[i] = sum;
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 0) {
                sum++;
            }
            leftSum[i] = sum;
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (forts[i] == 0) {
                sum++;
            }
            rightSum[i] = sum;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (forts[i] != 1) {
                continue;
            }
            int l = left[i];
            int r = right[i];
            int lSum = leftSum[i];
            int rSum = rightSum[i];
            if (l == 0 && r == 0) {
                continue;
            }
            if (l == 0) {
                ans = Math.max(ans, rSum);
                continue;
            }
            if (r == 0) {
                ans = Math.max(ans, lSum);
                continue;
            }
            ans = Math.max(ans, lSum + rSum);
        }
        return ans;
    }
}