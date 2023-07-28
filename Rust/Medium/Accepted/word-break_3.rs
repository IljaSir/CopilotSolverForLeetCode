impl Solution {
    pub fn word_break(s: String, word_dict: Vec<String>) -> bool {
        

        let mut dp = vec![false; s.len() + 1];
        dp[0] = true;
        for i in 1..=s.len() {
            for w in &word_dict {
                if i >= w.len() && s[i - w.len()..i] == *w {
                    dp[i] = dp[i] || dp[i - w.len()];
                }
            }
        }
        dp[s.len()]
    }
}