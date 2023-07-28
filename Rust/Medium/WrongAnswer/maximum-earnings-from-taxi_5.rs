impl Solution {
    pub fn max_taxi_earnings(n: i32, rides: Vec<Vec<i32>>) -> i64 {
        
        let n = n as usize;
        let mut dp = vec![0; n + 1];
        let mut rides = rides;
        rides.sort_by_key(|x| x[0]);
        let mut idx = 0;
        for i in 1..=n {
            dp[i] = dp[i - 1];
            while idx < rides.len() && rides[idx][0] == i as i32 {
                let (start, end, tip) = (rides[idx][0], rides[idx][1], rides[idx][2]);
                let j = idx + 1;
                idx = j;
                while idx < rides.len() && rides[idx][0] <= end {
                    idx += 1;
                }
                dp[end as usize] = dp[end as usize].max(dp[start as usize] + (end - start + tip) as i64);
            }
        }
        dp[n] as i64
    }
}