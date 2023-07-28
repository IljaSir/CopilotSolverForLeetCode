impl Solution {
    pub fn mincost_tickets(days: Vec<i32>, costs: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; 366];
        let mut i = 0;
        for day in 1..366 {
            if i < days.len() && day == days[i] {
                let a = dp[day-1] + costs[0];
                let b = dp[(day-7).max(0)] + costs[1];
                let c = dp[(day-30).max(0)] + costs[2];
                dp[day] = a.min(b.min(c));
                i += 1;
            } else {
                dp[day] = dp[day-1];
            }
        }
        dp[365]
    }
}