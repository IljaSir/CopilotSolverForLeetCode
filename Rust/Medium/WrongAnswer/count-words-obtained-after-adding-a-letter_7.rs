impl Solution {
    pub fn word_count(start_words: Vec<String>, target_words: Vec<String>) -> i32 {
        
        let mut count = 0;
        for word in target_words {
            for s in &start_words {
                if s.len() == word.len() && (0..s.len()).all(|i| s[i..].contains(&word[i..=i])) {
                    count += 1;
                    break;
                }
            }
        }
        count
    }
}