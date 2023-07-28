class Solution {
    public int longestCommonSubpath(int n, int[][] paths) {
        
        int lo = 1, hi = 100000;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (check(n, paths, mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi;
    }

    private boolean check(int n, int[][] paths, int l) {
        int p = 1000000007;
        int x = 113;
        int[][] h = new int[paths.length][paths[0].length - l + 1];
        int[] xL = new int[l];
        xL[0] = 1;
        for (int i = 1; i < l; i++) {
            xL[i] = (int)((long)xL[i - 1] * x % p);
        }
        for (int i = 0; i < paths.length; i++) {
            for (int j = 0; j < l; j++) {
                h[i][0] = (int)((long)h[i][0] * x + paths[i][j]) % p;
            }
            for (int j = 1; j <= paths[0].length - l; j++) {
                h[i][j] = (int)((long)(h[i][j - 1] + p - (long)paths[i][j - 1] * xL[l - 1] % p) * x + paths[i][j + l - 1]) % p;
            }
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i <= paths[0].length - l; i++) {
            seen.clear();
            for (int j = 0; j < paths.length; j++) {
                seen.add(h[j][i]);
            }
            if (seen.size() == 1) {
                return true;
            }
        }
        return false;
    }
}