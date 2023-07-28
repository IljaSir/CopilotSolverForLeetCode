impl Solution {
    pub fn longest_palindrome(word1: String, word2: String) -> i32 {
        
        let mut dp = vec![vec![0; word1.len() + word2.len()]; word1.len() + word2.len()];
        let mut res = 0;
        for i in 0..word1.len() + word2.len() {
            for j in (0..=i).rev() {
                if i == j {
                    dp[i][j] = 1;
                } else {
                    let c1 = if i < word1.len() {
                        word1.chars().nth(i).unwrap()
                    } else {
                        word2.chars().nth(i - word1.len()).unwrap()
                    };
                    let c2 = if j < word1.len() {
                        word1.chars().nth(j).unwrap()
                    } else {
                        word2.chars().nth(j - word1.len()).unwrap()
                    };
                    if c1 == c2 {
                        dp[i][j] = dp[i - 1][j + 1] + 2;
                        res = res.max(dp[i][j]);
                    } else {
                        dp[i][j] = dp[i - 1][j].max(dp[i][j + 1]);
                    }
                }
            }
        }
        res
    }
}