impl Solution {
    pub fn min_cost(n: i32, cuts: Vec<i32>) -> i32 {
        
        let n = n as usize;
        let mut cuts = cuts;
        cuts.push(0);
        cuts.push(n as i32);
        cuts.sort();
        let m = cuts.len();
        let mut dp = vec![vec![0; m]; m];
        for i in 0..m {
            dp[i][i] = 0;
        }
        for len in 2..m {
            for i in 0..(m - len) {
                let j = i + len;
                dp[i][j] = i32::max_value();
                for k in (i + 1)..j {
                    dp[i][j] = dp[i][j].min(dp[i][k] + dp[k][j]);
                }
                dp[i][j] += cuts[j] - cuts[i];
            }
        }
        dp[0][m - 1]
    }
}