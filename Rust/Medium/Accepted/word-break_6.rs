impl Solution {
    pub fn word_break(s: String, word_dict: Vec<String>) -> bool {
        

        let mut dp = vec![false; s.len() + 1];
        dp[0] = true;
        let mut word_dict = word_dict;
        word_dict.sort_by(|a, b| b.len().cmp(&a.len()));
        for i in 1..=s.len() {
            for word in &word_dict {
                if i >= word.len() && s[i - word.len()..i] == *word {
                    dp[i] = dp[i - word.len()] || dp[i];
                }
            }
        }
        dp[s.len()]
    }
}