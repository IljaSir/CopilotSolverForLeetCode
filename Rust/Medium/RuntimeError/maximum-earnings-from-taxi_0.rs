impl Solution {
    pub fn max_taxi_earnings(n: i32, rides: Vec<Vec<i32>>) -> i64 {
        
        let n = n as usize;
        let mut dp = vec![0; n + 1];
        let mut rides = rides;
        rides.sort_by(|a, b| a[1].cmp(&b[1]));
        let mut i = 0;
        for j in 1..=n {
            dp[j] = dp[j - 1];
            while i < rides.len() && rides[i][1] == j as i32 {
                let (start, end, tip) = (rides[i][0], rides[i][1], rides[i][2]);
                let mut k = 0;
                let mut l = i - 1;
                while k <= l {
                    let m = k + (l - k) / 2;
                    if rides[m][1] < start {
                        k = m + 1;
                    } else {
                        l = m - 1;
                    }
                }
                dp[j] = dp[j].max(dp[start as usize] + (end - start + tip) as i64);
                i += 1;
            }
        }
        dp[n] as i64
    }
}