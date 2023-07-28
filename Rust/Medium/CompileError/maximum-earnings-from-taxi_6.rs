impl Solution {
    pub fn max_taxi_earnings(n: i32, rides: Vec<Vec<i32>>) -> i64 {
        
        let n = n as usize;
        let mut dp = vec![0; n + 1];
        let mut rides: Vec<(usize, usize, i32)> = rides.iter().map(|x| (x[0] as usize, x[1] as usize, x[2])).collect();
        rides.sort_by(|a, b| a.1.cmp(&b.1));
        let mut i = 0;
        for j in 1..=n {
            dp[j] = dp[j - 1];
            while i < rides.len() && rides[i].1 == j {
                dp[j] = dp[j].max(dp[rides[i].0] + (rides[i].1 - rides[i].0 + rides[i].2) as i64);
                i += 1;
            }
        }
        dp[n] as i64
    }
}