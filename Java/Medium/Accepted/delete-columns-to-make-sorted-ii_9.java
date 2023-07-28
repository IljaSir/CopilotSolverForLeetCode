class Solution {
    public int minDeletionSize(String[] strs) {
        
        int n = strs.length;
        int m = strs[0].length();
        boolean[] deleted = new boolean[n];
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            boolean ok = true;
            for (int j = 1; j < n; ++j) {
                if (!deleted[j] && strs[j].charAt(i) < strs[j-1].charAt(i)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                for (int j = 1; j < n; ++j) {
                    if (strs[j].charAt(i) > strs[j-1].charAt(i)) {
                        deleted[j] = true;
                    }
                }
            } else {
                ans++;
            }
        }
        return ans;
    }
}