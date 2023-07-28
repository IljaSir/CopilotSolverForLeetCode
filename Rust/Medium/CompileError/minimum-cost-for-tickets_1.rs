impl Solution {
    pub fn mincost_tickets(days: Vec<i32>, costs: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; 366];
        let mut i = 0;
        for d in 1..366 {
            if d != days[i] {
                dp[d] = dp[d - 1];
            } else {
                dp[d] = dp[d - 1] + costs[0];
                dp[d] = dp[d].min(dp[d - 7].max(0) + costs[1]);
                dp[d] = dp[d].min(dp[d - 30].max(0) + costs[2]);
                i += 1;
            }
        }
        dp[365]
    }
}