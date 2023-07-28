impl Solution {
    pub fn count_vowel_strings(n: i32) -> i32 {
        
        let n = n as usize;
        let mut dp = vec![vec![0; 5]; n + 1];
        for i in 0..=n {
            dp[i][0] = 1;
        }
        for i in 1..=n {
            for j in 1..=4 {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        dp[n][4]
    }
}