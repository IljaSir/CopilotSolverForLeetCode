impl Solution {
    pub fn word_break(s: String, word_dict: Vec<String>) -> Vec<String> {
        
        let mut dp = vec![vec![]; s.len() + 1];
        dp[0] = vec![String::new()];
        for i in 1..=s.len() {
            for j in 0..i {
                if !dp[j].is_empty() && word_dict.contains(&s[j..i].to_string()) {
                    for word in &dp[j] {
                        dp[i].push(format!("{}{}", word, if word.is_empty() { "" } else { " " } ).to_string() + &s[j..i].to_string());
                    }
                }
            }
        }
        dp[s.len()].clone()
    }
}