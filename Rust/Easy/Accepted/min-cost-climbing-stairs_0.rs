impl Solution {
    pub fn min_cost_climbing_stairs(cost: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; cost.len()];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for i in 2..cost.len() {
            dp[i] = cost[i] + std::cmp::min(dp[i-1], dp[i-2]);
        }
        return std::cmp::min(dp[cost.len()-1], dp[cost.len()-2]);
    }
}