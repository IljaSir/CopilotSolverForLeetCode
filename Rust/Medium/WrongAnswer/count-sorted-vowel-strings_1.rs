impl Solution {
    pub fn count_vowel_strings(n: i32) -> i32 {
        
        let mut dp = vec![1; 5];
        for _ in 1..n {
            for i in (1..5).rev() {
                dp[i] += dp[i - 1];
            }
        }
        dp.iter().sum()
    }
}