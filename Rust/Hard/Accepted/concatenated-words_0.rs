impl Solution {
    pub fn find_all_concatenated_words_in_a_dict(words: Vec<String>) -> Vec<String> {
        
        let mut words = words;
        words.sort_by(|a, b| a.len().cmp(&b.len()));
        let mut res = Vec::new();
        let mut set = std::collections::HashSet::new();
        for word in words {
            if Self::is_concatenated(&word, &set) {
                res.push(word.clone());
            }
            set.insert(word);
        }
        res
    }
    fn is_concatenated(word: &str, set: &std::collections::HashSet<String>) -> bool {
        if word.len() == 0 {
            return false;
        }
        let mut dp = vec![false; word.len() + 1];
        dp[0] = true;
        for i in 1..=word.len() {
            for j in 0..i {
                if dp[j] && set.contains(&word[j..i]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        dp[word.len()]
    }
}