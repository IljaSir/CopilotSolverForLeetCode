impl Solution {
    pub fn max_taxi_earnings(n: i32, rides: Vec<Vec<i32>>) -> i64 {
        
        let mut dp = vec![0; n as usize + 1];
        let mut rides = rides;
        rides.sort_by_key(|x| x[1]);
        for i in 0..rides.len() {
            let mut lo = 0;
            let mut hi = i;
            while lo < hi {
                let mid = (lo + hi + 1) / 2;
                if rides[mid][1] <= rides[i][0] {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            dp[rides[i][1] as usize] = dp[rides[i][1] as usize].max(dp[rides[i][0] as usize] + (rides[i][1] - rides[i][0] + rides[i][2]) as i64);
            dp[rides[i][1] as usize] = dp[rides[i][1] as usize].max(dp[lo as usize] + (rides[i][1] - rides[lo][0] + rides[i][2]) as i64);
        }
        *dp.last().unwrap() as i64
    }
}