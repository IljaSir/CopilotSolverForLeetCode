impl Solution {
    pub fn max_product(s: String) -> i32 {
        
        let mut res = 0;
        let n = s.len();
        let s = s.as_bytes();
        let mut dp = vec![vec![0; n]; n];
        for i in 0..n {
            dp[i][i] = 1;
            for j in i+1..n {
                dp[i][j] = dp[i][j-1] + if s[i] == s[j] {2} else {0};
                res = res.max(dp[i][j]);
            }
        }
        for i in 0..n {
            for j in i+1..n {
                for k in j+1..n {
                    if dp[i][j] == j-i+1 && dp[j][k] == k-j+1 {
                        res = res.max((j-i+1) * (k-j+1));
                    }
                }
            }
        }
        res as i32
    }
}