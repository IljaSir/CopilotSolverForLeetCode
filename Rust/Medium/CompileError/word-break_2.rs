impl Solution {
    pub fn word_break(s: String, word_dict: Vec<String>) -> bool {
        

        let n = s.len();
        let mut dp = vec![false; n + 1];
        dp[0] = true;
        for i in 0..n {
            for j in 0..=i {
                if dp[j] && word_dict.contains(&s[j..=i]) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        dp[n]
    }
}