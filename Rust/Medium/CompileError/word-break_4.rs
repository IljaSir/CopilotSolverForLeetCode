impl Solution {
    pub fn word_break(s: String, word_dict: Vec<String>) -> bool {
        

        let word_dict: Vec<&str> = word_dict.iter().map(|s| s.as_str()).collect();
        let mut dp = vec![false; s.len() + 1];
        dp[0] = true;
        for i in 0..s.len() {
            for j in 0..i + 1 {
                if dp[j] && word_dict.contains(&s[j..i + 1]) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        dp[s.len()]
    }
}