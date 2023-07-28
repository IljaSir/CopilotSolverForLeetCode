impl Solution {
    pub fn num_squares(n: i32) -> i32 {
        

        let mut dp = vec![0; (n + 1) as usize];
        for i in 1..=n {
            let mut min = i;
            let mut j = 1;
            while j * j <= i {
                min = min.min(dp[(i - j * j) as usize] + 1);
                j += 1;
            }
            dp[i as usize] = min;
        }
        dp[n as usize]
    }
}