impl Solution {
    pub fn word_break(s: String, word_dict: Vec<String>) -> Vec<String> {
        
        let mut dp = vec![false; s.len() + 1];
        dp[0] = true;
        let mut word_set = std::collections::HashSet::new();
        let mut max_word_length = 0;
        for word in word_dict.iter() {
            word_set.insert(word);
            max_word_length = max_word_length.max(word.len());
        }
        for i in 0..s.len() {
            if !dp[i] {
                continue;
            }
            for j in i + 1..=s.len().min(i + max_word_length) {
                if word_set.contains(&s[i..j]) {
                    dp[j] = true;
                }
            }
        }
        if !dp[s.len()] {
            return vec![];
        }
        let mut ans = vec![];
        let mut path = vec![];
        Self::dfs(&s, &word_set, 0, &mut dp, &mut path, &mut ans);
        ans
    }
    fn dfs(s: &str, word_set: &std::collections::HashSet<&String>, start: usize, dp: &mut Vec<bool>, path: &mut Vec<String>, ans: &mut Vec<String>) {
        if start == s.len() {
            ans.push(path.join(" "));
            return;
        }
        for end in start + 1..=s.len() {
            if !dp[end] {
                continue;
            }
            let word = &s[start..end];
            if word_set.contains(word) {
                path.push(word.to_string());
                Self::dfs(s, word_set, end, dp, path, ans);
                path.pop();
            }
        }