impl Solution {
    pub fn find_all_concatenated_words_in_a_dict(words: Vec<String>) -> Vec<String> {
        
        let mut words: Vec<String> = words.iter().map(|s| s.to_string()).collect();
        words.sort_by(|a, b| a.len().cmp(&b.len()));
        let mut word_set: HashSet<String> = HashSet::new();
        let mut res: Vec<String> = Vec::new();
        for word in words {
            if Self::is_concatenated(&word, &word_set) {
                res.push(word.clone());
            }
            word_set.insert(word);
        }
        res
    }
    fn is_concatenated(word: &String, word_set: &HashSet<String>) -> bool {
        if word_set.contains(word) {
            return true;
        }
        let mut dp: Vec<bool> = vec![false; word.len() + 1];
        dp[0] = true;
        for i in 1..word.len() + 1 {
            for j in 0..i {
                if dp[j] && word_set.contains(&word[j..i]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        dp[word.len()]
    }
}