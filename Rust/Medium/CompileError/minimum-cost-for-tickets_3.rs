impl Solution {
    pub fn mincost_tickets(days: Vec<i32>, costs: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; 366];
        let mut days = days;
        days.push(366);
        let mut i = 1;
        let mut j = 0;
        while i < 366 {
            if i == days[j] {
                dp[i] = dp[i-1] + costs[0];
                dp[i] = dp[i].min(dp[i-7].max(0) + costs[1]);
                dp[i] = dp[i].min(dp[i-30].max(0) + costs[2]);
                j += 1;
            } else {
                dp[i] = dp[i-1];
            }
            i += 1;
        }
        dp[365]
    }
}