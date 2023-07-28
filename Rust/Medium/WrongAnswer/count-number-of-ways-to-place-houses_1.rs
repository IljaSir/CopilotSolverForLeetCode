impl Solution {
    pub fn count_house_placements(n: i32) -> i32 {
        
        let mut dp = vec![0; n as usize + 1];
        dp[0] = 1;
        dp[1] = 4;
        for i in 2..=n as usize {
            dp[i] = ((dp[i-1] as i64 + dp[i-2] as i64) * 2) as i32;
        }
        dp[n as usize]
    }
}