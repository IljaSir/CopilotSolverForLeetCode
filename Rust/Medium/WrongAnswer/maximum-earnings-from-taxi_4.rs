impl Solution {
    pub fn max_taxi_earnings(n: i32, rides: Vec<Vec<i32>>) -> i64 {
        
        let mut dp = vec![0; n as usize];
        let mut rides = rides;
        rides.sort_by(|a, b| a[0].cmp(&b[0]));
        for i in 0..n as usize {
            dp[i] = if i == 0 { 0 } else { dp[i - 1] };
            let mut j = rides.binary_search_by(|a| a[0].cmp(&(i as i32 + 1))).unwrap_or_else(|x| x);
            while j > 0 && rides[j - 1][0] == i as i32 + 1 {
                j -= 1;
            }
            while j < rides.len() && rides[j][0] == i as i32 + 1 {
                let mut k = rides.binary_search_by(|a| a[0].cmp(&rides[j][1])).unwrap_or_else(|x| x);
                while k > 0 && rides[k - 1][0] == rides[j][1] {
                    k -= 1;
                }
                if k == rides.len() {
                    dp[i] = dp[i].max((rides[j][1] - rides[j][0] + rides[j][2]) as i64);
                } else {
                    dp[i] = dp[i].max(dp[rides[k][0] as usize - 1] + (rides[j][1] - rides[j][0] + rides[j][2]) as i64);
                }
                j += 1;
            }
        }
        dp[n as usize - 1]
    }
}