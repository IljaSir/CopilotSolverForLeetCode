impl Solution {
    pub fn two_egg_drop(n: i32) -> i32 {
        
        let mut dp = vec![0; n as usize + 1];
        let mut i = 0;
        while dp[i] < n {
            i += 1;
            dp[i] = dp[i - 1] + i;
        }
        i as i32
    }
}