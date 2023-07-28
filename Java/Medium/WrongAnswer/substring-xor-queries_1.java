class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        
        int n = s.length();
        int[] a = new int[n+1];
        for (int i = 0; i < n; i++) {
            a[i+1] = a[i] ^ (s.charAt(i) - '0');
        }
        int[][] ans = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            int first = queries[i][0], second = queries[i][1];
            int l = 0, r = n;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if ((a[mid] ^ first) == second) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (l == n) {
                ans[i] = new int[]{-1, -1};
            } else {
                ans[i] = new int[]{l, r};
            }
        }
        return ans;
    }
}