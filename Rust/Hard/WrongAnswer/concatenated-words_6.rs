impl Solution {
    pub fn find_all_concatenated_words_in_a_dict(words: Vec<String>) -> Vec<String> {
        
        let mut dict = std::collections::HashSet::new();
        for w in &words {
            dict.insert(w.as_str());
        }
        let mut res = vec![];
        for w in &words {
            if Self::is_concatenated(w, &dict) {
                res.push(w.to_string());
            }
        }
        res
    }
    fn is_concatenated(word: &str, dict: &std::collections::HashSet<&str>) -> bool {
        let mut dp = vec![false; word.len() + 1];
        dp[0] = true;
        for i in 1..=word.len() {
            for j in 0..i {
                if dp[j] && dict.contains(&word[j..i]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        dp[word.len()]
    }
}