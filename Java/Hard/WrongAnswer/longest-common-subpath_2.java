class Solution {
    public int longestCommonSubpath(int n, int[][] paths) {
        
        int low = 0;
        int high = n;
        while (low < high) {
            int mid = (high + low + 1) / 2;
            if (check(paths, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    private boolean check(int[][] paths, int len) {
        int mod = (int) 1e9 + 7;
        int base = 113;
        long baseL = 1;
        for (int i = 0; i < len; i++) {
            baseL = baseL * base % mod;
        }
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < paths[0].length - len + 1; i++) {
            long hash = 0;
            for (int j = 0; j < len; j++) {
                hash = (hash * base + paths[0][i + j]) % mod;
            }
            set.add(hash);
        }
        for (int i = 1; i < paths.length; i++) {
            HashSet<Long> set2 = new HashSet<>();
            for (int j = 0; j < paths[i].length - len + 1; j++) {
                long hash = 0;
                for (int k = 0; k < len; k++) {
                    hash = (hash * base + paths[i][j + k]) % mod;
                }
                if (set.contains(hash)) {
                    set2.add(hash);
                }
            }
            if (set2.size() == 0) {
                return false;
            }
            set = set2;
        }
        return true;
    }
}