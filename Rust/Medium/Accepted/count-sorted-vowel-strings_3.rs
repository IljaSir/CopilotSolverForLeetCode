impl Solution {
    pub fn count_vowel_strings(n: i32) -> i32 {
        
        let mut dp = vec![1; 5];
        for _ in 1..n {
            for j in 1..5 {
                dp[j] += dp[j - 1];
            }
        }
        dp.iter().sum()
    }
}