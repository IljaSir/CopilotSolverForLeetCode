impl Solution {
    pub fn total_cost(costs: Vec<i32>, k: i32, candidates: i32) -> i64 {
        
        let mut costs = costs;
        costs.sort();
        let mut dp = vec![vec![0; k as usize + 1]; candidates as usize + 1];
        for i in 0..costs.len() {
            for j in 0..k as usize + 1 {
                for l in 0..candidates as usize + 1 {
                    if j == 0 || l == 0 {
                        continue;
                    }
                    if i + 1 < l {
                        continue;
                    }
                    dp[l][j] = std::cmp::max(dp[l][j], dp[l - 1][j - 1] + costs[i] as i64);
                }
            }
        }
        dp[candidates as usize][k as usize] as i64
    }
}