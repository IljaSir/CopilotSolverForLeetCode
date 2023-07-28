impl Solution {
    pub fn word_break(s: String, word_dict: Vec<String>) -> Vec<String> {
        
        let mut dp = vec![vec![]; s.len() + 1];
        dp[0] = vec![vec![]];
        for i in 0..s.len() {
            if dp[i].is_empty() {
                continue;
            }
            for word in &word_dict {
                if s[i..].starts_with(word) {
                    for mut v in &dp[i] {
                        let mut v2 = v.clone();
                        v2.push(word.clone());
                        dp[i + word.len()].push(v2);
                    }
                }
            }
        }
        dp[s.len()].iter().map(|v| v.join(" ")).collect()
    }
}