impl Solution {
    pub fn total_cost(costs: Vec<i32>, k: i32, candidates: i32) -> i64 {
        
        let mut costs = costs;
        costs.sort();
        let mut dp = vec![vec![0; k as usize + 1]; costs.len() + 1];
        for i in 1..costs.len() + 1 {
            for j in 1..k as usize + 1 {
                dp[i][j] = dp[i - 1][j];
                if i as i32 >= candidates {
                    dp[i][j] = std::cmp::min(dp[i][j], dp[i - candidates as usize][j - 1] + costs[i - 1] as i64);
                }
            }
        }
        dp[costs.len()][k as usize]
    }
}