impl Solution {
    pub fn max_taxi_earnings(n: i32, rides: Vec<Vec<i32>>) -> i64 {
        
        let n = n as usize;
        let mut dp = vec![0; n + 1];
        let mut rides = rides;
        rides.sort_by_key(|x| x[1]);
        let mut idx = 0;
        for i in 1..=n {
            dp[i] = std::cmp::max(dp[i], dp[i - 1]);
            while idx < rides.len() && rides[idx][1] == i as i32 {
                let (start, end, tip) = (rides[idx][0], rides[idx][1], rides[idx][2]);
                let mut l = 0;
                let mut r = idx;
                while l < r {
                    let mid = (l + r) / 2;
                    if rides[mid][1] < start {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                dp[i] = std::cmp::max(dp[i], dp[start as usize] + (end - start + tip) as i64);
                idx += 1;
            }
        }
        dp[n] as i64
    }
}