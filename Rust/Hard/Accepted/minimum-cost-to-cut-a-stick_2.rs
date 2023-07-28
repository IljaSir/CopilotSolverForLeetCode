impl Solution {
    pub fn min_cost(n: i32, cuts: Vec<i32>) -> i32 {
        
        let mut cuts = cuts;
        cuts.push(0);
        cuts.push(n);
        cuts.sort();
        let mut dp = vec![vec![0; cuts.len()]; cuts.len()];
        for i in (0..cuts.len()).rev() {
            for j in i + 1..cuts.len() {
                if j - i < 2 {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = i32::MAX;
                    for k in i + 1..j {
                        dp[i][j] = dp[i][j].min(dp[i][k] + dp[k][j]);
                    }
                    dp[i][j] += cuts[j] - cuts[i];
                }
            }
        }
        dp[0][cuts.len() - 1]
    }
}