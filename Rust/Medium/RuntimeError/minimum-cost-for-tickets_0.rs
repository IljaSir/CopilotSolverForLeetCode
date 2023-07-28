impl Solution {
    pub fn mincost_tickets(days: Vec<i32>, costs: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; 366];
        let mut travel = vec![false; 366];
        for i in days {
            travel[i as usize] = true;
        }
        for i in 1..366 {
            if !travel[i] {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + costs[0];
                dp[i] = dp[i].min(dp[(i - 7).max(0)] + costs[1]);
                dp[i] = dp[i].min(dp[(i - 30).max(0)] + costs[2]);
            }
        }
        dp[365]
    }
}