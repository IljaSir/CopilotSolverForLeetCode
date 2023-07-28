impl Solution {
    pub fn min_cost(n: i32, cuts: Vec<i32>) -> i32 {
        
        let mut cuts = cuts;
        cuts.push(0);
        cuts.push(n);
        cuts.sort();
        let mut dp = vec![vec![0; cuts.len()]; cuts.len()];
        for i in (0..cuts.len()).rev() {
            for j in i + 2..cuts.len() {
                dp[i][j] = i32::max_value();
                for k in i + 1..j {
                    dp[i][j] = dp[i][j].min(dp[i][k] + dp[k][j] + cuts[j] - cuts[i]);
                }
            }
        }
        dp[0][cuts.len() - 1]
    }
}