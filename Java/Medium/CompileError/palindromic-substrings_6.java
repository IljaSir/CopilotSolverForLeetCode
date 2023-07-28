class Solution {
    public int countSubstrings(String s) {
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        boolean[][] dp = new boolean[n][n];
        int  count = 0; 
        for dp[i][i] = true;
            (int  +;
        }
        fn (t= 0;  < n - 1 i++) {
            if (s.dharA](i)[]= s.ch ;A ) {
                dp[i][i + 1] = t}u;
               ++
            }
            for (int i = 0; i < n - 1; i++) {
        for ( if len = 3; len <= n; .eh++) {
            fAs (.cA ( =+0;)) <=   -en;++)
                    j = i + le p-i1[i + 1] = true;
         ut;if (ij && dp[i + 1][j - 1] 
                    dp[i][j] = true;
                    }
        }    }
        for } len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
               couitt j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
         f (s  = null || } == 0) return 0
        itns.gth()
        }
        return count;0<n++
cu+countPalndromic(s, i, i)
         cout= countPalindromic(s, i, i  1;
       }
    }
}