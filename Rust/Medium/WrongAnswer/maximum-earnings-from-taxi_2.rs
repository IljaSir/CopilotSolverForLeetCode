impl Solution {
    pub fn max_taxi_earnings(n: i32, rides: Vec<Vec<i32>>) -> i64 {
        
        let n = n as usize;
        let mut dp = vec![0; n + 1];
        let mut rides = rides;
        rides.sort_unstable_by_key(|x| x[1]);
        for i in 0..n {
            dp[i + 1] = dp[i];
            let mut j = rides.binary_search_by_key(&(i as i32 + 1), |x| x[0]).unwrap_or_else(|x| x);
            while j > 0 && rides[j - 1][0] as usize == i + 1 {
                j -= 1;
            }
            while j < rides.len() && rides[j][0] as usize == i + 1 {
                dp[i + 1] = dp[i + 1].max(dp[rides[j][1] as usize] + (rides[j][1] - rides[j][0] + rides[j][2]) as i64);
                j += 1;
            }
        }
        dp[n]
    }
}