impl Solution {
    pub fn count_house_placements(n: i32) -> i32 {
        
        // let mut dp = vec![vec![0; n as usize + 1]; 2];
        let mut dp = vec![0; n as usize + 1];
        
        dp[1] = 4;
        dp[2] = 9;
        
        for i in 3..=n {
            dp[i as usize] = (dp[i as usize - 1] + dp[i as usize - 2]) % 1000000007;
        }
        
        dp[n as usize]
    }
}