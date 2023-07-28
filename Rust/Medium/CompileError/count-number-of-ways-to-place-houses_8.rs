impl Solution {
    pub fn count_house_placements(n: i32) -> i32 {
        
        let mut dp = vec![0; (n + 1) as usize];
        let modulo = 1e9 as i64 + 7.0;
        dp[0] = 1;
        dp[1] = 4;
        for i in 2..=n {
            dp[i as usize] = ((dp[(i - 1) as usize] as i64 * 3) % modulo + dp[(i - 2) as usize] as i64) as i32;
        }
        dp[n as usize]
    }
}