impl Solution {
    pub fn word_break(s: String, word_dict: Vec<String>) -> Vec<String> {
        
        let mut words = std::collections::HashSet::new();
        for word in word_dict {
            words.insert(word);
        }
        let mut dp = vec![vec![]; s.len() + 1];
        dp[0].push(0);
        for i in 0..s.len() {
            if !dp[i].is_empty() {
                for j in i + 1..=s.len() {
                    if words.contains(&s[i..j]) {
                        dp[j].push(i);
                    }
                }
            }
        }
        let mut result = vec![];
        if !dp[s.len()].is_empty() {
            Self::backtrack(&s, &dp, s.len(), &mut vec![], &mut result);
        }
        result
    }
    fn backtrack(s: &str, dp: &Vec<Vec<usize>>, i: usize, path: &mut Vec<String>, result: &mut Vec<String>) {
        if i == 0 {
            result.push(path.iter().rev().map(|s| s.as_str()).collect::<Vec<&str>>().join(" "));
        } else {
            for j in &dp[i] {
                path.push(s[*j..i].to_string());
                Self::backtrack(s, dp, *j, path, result);
                path.pop();
            }
        }