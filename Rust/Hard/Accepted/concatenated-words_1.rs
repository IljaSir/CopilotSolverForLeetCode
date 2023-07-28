impl Solution {
    pub fn find_all_concatenated_words_in_a_dict(words: Vec<String>) -> Vec<String> {
        
        let mut words = words;
        words.sort_by_key(|s| s.len());
        let mut res = Vec::new();
        let mut set = std::collections::HashSet::new();
        for word in &words {
            if Solution::can_form(word, &set) {
                res.push(word.clone());
            }
            set.insert(word);
        }
        res
    }
    fn can_form(word: &String, set: &std::collections::HashSet<&String>) -> bool {
        if set.is_empty() {
            return false;
        }
        let mut dp = vec![false; word.len() + 1];
        dp[0] = true;
        for i in 0..=word.len() {
            for j in 0..i {
                if !dp[j] {
                    continue;
                }
                if set.contains(&word[j..i].to_string()) {
                    dp[i] = true;
                    break;
                }
            }
        }
        dp[word.len()]
    }
}