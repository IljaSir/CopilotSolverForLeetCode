impl Solution {
    pub fn max_taxi_earnings(n: i32, rides: Vec<Vec<i32>>) -> i64 {
        
        let mut dp = vec![0; n as usize + 1];
        let mut max = 0;
        for i in (1..=n).rev() {
            while !rides.is_empty() && rides[0][0] == i {
                let ride = rides.remove(0);
                max = std::cmp::max(max, ride[2] + dp[ride[1] as usize]);
            }
            dp[i as usize] = max;
        }
        max as i64
    }
}