impl Solution {
    pub fn word_break(s: String, word_dict: Vec<String>) -> bool {
        

        let mut dp = vec![false; s.len() + 1];
        dp[0] = true;
        let word_dict = word_dict.iter().map(|s| s.as_str()).collect::<Vec<&str>>();
        for i in 0..s.len() {
            for j in i..s.len() {
                if dp[i] && word_dict.contains(&s[i..=j]) {
                    dp[j + 1] = true;
                }
            }
        }
        dp[s.len()]
    }
}