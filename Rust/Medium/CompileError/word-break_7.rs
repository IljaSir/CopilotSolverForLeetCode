impl Solution {
    pub fn word_break(s: String, word_dict: Vec<String>) -> bool {
        

        let mut dp = vec![false; s.len() + 1];
        dp[0] = true;
        let mut word_dict: Vec<&str> = word_dict.iter().map(|s| s.as_str()).collect();
        word_dict.sort();
        for i in 0..s.len() {
            for j in i + 1..=s.len() {
                if dp[i] && word_dict.binary_search(&s[i..j]).is_ok() {
                    dp[j] = true;
                }
            }
        }
        dp[s.len()]
    }
}