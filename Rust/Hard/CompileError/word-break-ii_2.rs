impl Solution {
    pub fn word_break(s: String, word_dict: Vec<String>) -> Vec<String> {
        
        let mut dp = vec![vec![]; s.len() + 1];
        dp[0] = vec!["".to_string()];
        for i in 1..=s.len() {
            for j in 0..i {
                if dp[j].len() > 0 && word_dict.contains(&s[j..i].to_string()) {
                    for k in 0..dp[j].len() {
                        dp[i].push(format!("{}{}{}", dp[j][k], if dp[j][k].len() > 0 { " " } else { "" }, &s[j..i]));
                    }
                }
            }
        }
        dp[s.len()].clone()
    }
}