impl Solution {
    pub fn two_egg_drop(n: i32) -> i32 {
        
        let mut dp = vec![0; n as usize + 1];
        let mut m = 0;
        while dp[m] < n {
            m += 1;
            for i in (1..=n as usize).rev() {
                dp[i] = dp[i-1] + 1 + dp[i];
            }
        }
        m as i32
    }
}