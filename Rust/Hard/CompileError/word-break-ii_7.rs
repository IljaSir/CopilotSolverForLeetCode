impl Solution {
    pub fn word_break(s: String, word_dict: Vec<String>) -> Vec<String> {
        
        let mut dp = vec![vec![]; s.len() + 1];
        dp[0] = vec![String::new()];
        for i in 0..s.len() {
            for j in i + 1..=s.len() {
                if dp[i].len() > 0 && word_dict.contains(&s[i..j].to_string()) {
                    dp[j] = dp[j]
                        .iter()
                        .map(|x| {
                            if x.len() == 0 {
                                s[i..j].to_string()
                            } else {
                                format!("{} {}", x, s[i..j])
                            }
                        })
                        .collect();
                }
            }
        }
        dp[s.len()].clone()
    }
}