impl Solution {
    pub fn min_cost_climbing_stairs(cost: Vec<i32>) -> i32 {
        
        let n = cost.len();
        let mut dp = vec![0; n+1];
        for i in 2..n+1 {
            dp[i] = cost[i-1] + dp[i-1].min(dp[i-2]);
        }
        dp[n].min(dp[n-1])
    }
}