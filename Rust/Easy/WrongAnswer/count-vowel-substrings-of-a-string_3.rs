impl Solution {
    pub fn count_vowel_substrings(word: String) -> i32 {
        
        let mut dp = vec![vec![0; word.len()]; word.len()];
        for i in 0..word.len() {
            dp[i][i] = 1;
        }
        let mut res = word.len();
        for i in 0..word.len() {
            for j in (i + 1)..word.len() {
                if word.chars().nth(j).unwrap() == word.chars().nth(j - 1).unwrap() {
                    dp[i][j] = dp[i][j - 1];
                } else if word.chars().nth(j).unwrap() == 'a' && word.chars().nth(j - 1).unwrap() == 'u' {
                    dp[i][j] = dp[i][j - 1];
                } else if word.chars().nth(j).unwrap() == 'e' && word.chars().nth(j - 1).unwrap() == 'i' {
                    dp[i][j] = dp[i][j - 1];
                } else if word.chars().nth(j).unwrap() == 'i' && word.chars().nth(j - 1).unwrap() == 'e' {
                    dp[i][j] = dp[i][j - 1];
                } else if word.chars().nth(j).unwrap() == 'o' && word.chars().nth(j - 1).unwrap() == 'u' {
                    dp[i][j] = dp[i][j - 1];
                } else if word.chars().nth(j).unwrap() == 'u' && word.chars().nth(j - 1).unwrap() == 'a' {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] + 1;
                }
                res += dp[i][j];
            }
        }
        res as i32
    }
}