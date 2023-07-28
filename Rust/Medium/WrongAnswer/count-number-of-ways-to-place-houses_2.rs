impl Solution {
    pub fn count_house_placements(n: i32) -> i32 {
        
        let mut dp = vec![0; n as usize + 1];
        dp[0] = 1;
        dp[1] = 1;
        for i in 2..=n as usize {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        let mut ans = dp[n as usize];
        ans = (ans * ans) % 1000000007;
        ans as i32
    }
}