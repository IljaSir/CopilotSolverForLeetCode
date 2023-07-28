impl Solution {
    pub fn num_squares(n: i32) -> i32 {
        

        let n = n as usize;
        let mut dp = vec![0; n+1];
        for i in 1..=n {
            let mut j = 1;
            let mut min = i;
            while j*j <= i {
                min = min.min(dp[i - j*j] + 1);
                j += 1;
            }
            dp[i] = min;
        }
        dp[n] as i32
    }
}