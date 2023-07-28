class Solution {
    public int longestCommonSubpath(int n, int[][] paths) {
        
        int minLen = Integer.MAX_VALUE;
        for (int[] path : paths) {
            minLen = Math.min(minLen, path.length);
        }
        int lo = 0, hi = minLen;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (check(mid, n, paths)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private boolean check(int len, int n, int[][] paths) {
        int p = 1000000007;
        int pInv = 1000000006;
        long h = 1;
        for (int i = 0; i < len; i++) {
            h = h * p % pInv;
        }
        long[] vals = new long[paths.length];
        for (int i = 0; i < paths.length; i++) {
            long val = 0;
            for (int j = 0; j < len; j++) {
                val = (val * p + paths[i][j]) % pInv;
            }
            vals[i] = val;
        }
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < paths.length; i++) {
            set.clear();
            long val = 0;
            for (int j = 0; j < paths[i].length; j++) {
                val = (val * p + paths[i][j]) % pInv;
                if (j >= len) {
                    val = (val - paths[i][j - len] * h % pInv + pInv) % pInv;
                }
                if (j >= len - 1) {
                    set.add(val);
                }
            }
            if (i == 0 || set.containsAll(vals)) {
                vals = set.stream().mapToLong(Long::longValue).toArray();
            } else {
                return false;
            }
        }
        return true;
    }
}