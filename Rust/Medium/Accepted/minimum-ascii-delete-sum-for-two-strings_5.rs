impl Solution {
    pub fn minimum_delete_sum(s1: String, s2: String) -> i32 {
        

        let s1: Vec<char> = s1.chars().collect();
        let s2: Vec<char> = s2.chars().collect();
        let len1 = s1.len();
        let len2 = s2.len();
        let mut dp = vec![vec![0; len2+1]; len1+1];
        for i in 1..=len1 {
            dp[i][0] = dp[i-1][0] + s1[i-1] as i32;
        }
        for j in 1..=len2 {
            dp[0][j] = dp[0][j-1] + s2[j-1] as i32;
        }
        for i in 1..=len1 {
            for j in 1..=len2 {
                if s1[i-1] == s2[j-1] {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i-1][j-1] + s1[i-1] as i32 + s2[j-1] as i32;
                }
                dp[i][j] = dp[i][j].min(dp[i-1][j] + s1[i-1] as i32);
                dp[i][j] = dp[i][j].min(dp[i][j-1] + s2[j-1] as i32);
            }
        }
        dp[len1][len2]
    }
}