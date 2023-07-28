class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        
        int n = prizePositions.length;
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (prizePositions[i] == prizePositions[i - 1] ? 0 : 1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int l = i, r = n - 1, pos = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (prizePositions[mid] - prizePositions[i] <= k) {
                    pos = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (pos == -1) {
                continue;
            }
            if (i == 0) {
                res = Math.max(res, prefix[pos]);
            } else {
                res = Math.max(res, prefix[pos] - prefix[i - 1]);
            }
        }
        return res;
    }
}