class Solution {
    public int captureForts(int[] forts) {
        
        int[] left = new int[forts.length];
        int[] right = new int[forts.length];
        int[] pre = new int[forts.length];
        int[] suf = new int[forts.length];
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 0) {
                pre[i] = 1;
            }
            if (i > 0) {
                pre[i] += pre[i - 1];
            }
        }
        for (int i = forts.length - 1; i >= 0; i--) {
            if (forts[i] == 0) {
                suf[i] = 1;
            }
            if (i < forts.length - 1) {
                suf[i] += suf[i + 1];
            }
        }
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1) {
                left[i] = 1;
            }
            if (i > 0) {
                left[i] += left[i - 1];
            }
        }
        for (int i = forts.length - 1; i >= 0; i--) {
            if (forts[i] == 1) {
                right[i] = 1;
            }
            if (i < forts.length - 1) {
                right[i] += right[i + 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 0) {
                int leftSum = 0;
                if (i > 0) {
                    leftSum = pre[i - 1] + left[i - 1];
                }
                int rightSum = 0;
                if (i < forts.length - 1) {
                    rightSum = suf[i + 1] + right[i + 1];
                }
                ans = Math.max(ans, leftSum + rightSum);
            }
        }
        return ans;
    }
}