impl Solution {
    pub fn longest_common_subsequence(text1: String, text2: String) -> i32 {
        
        let (text1, text2) = (text1.into_bytes(), text2.into_bytes());
        let (l1, l2) = (text1.len(), text2.len());
        let mut dp = vec![vec![0; l2 + 1]; l1 + 1];
        for i in 1..=l1 {
            for j in 1..=l2 {
                if text1[i - 1] == text2[j - 1] {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j].max(dp[i][j - 1]);
                }
            }
        }
        dp[l1][l2]
    }
}