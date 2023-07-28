class Solution {
    public int numDupDigitsAtMostN(int n) {
        
        char[] A = Integer.toString(n + 1).toCharArray();
        int n = A.length;

        // dp[i] = # of unique numbers with i digits
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i)
            dp[i] = dp[i-1] * (9 - i + 2);

        // For each i-digit number with digits (A[0], A[1], ..., A[i-1]),
        // how many of them are less than N?

        // For example, if N = 534, and we're at i = 2,
        // the answer is 4 * 9 * 8, since the first digit can be
        // anything less than 5, and the next two digits can be anything
        // less than 3, 4, or 5.

        int ans = 0;
        Set<Integer> seen = new HashSet();
        for (int i = 0; i < n; ++i) {
            int d = A[i] - '0';
            for (int j = i > 0 ? 0 : 1; j < d; ++j)
                if (!seen.contains(j))
                    ans += dp[n - 1 - i];
            if (seen.contains(d)) break;
            seen.add(d);
        }

        return n - 1 - ans;
    }
}