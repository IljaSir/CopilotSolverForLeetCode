impl Solution {
    pub fn count_prefixes(words: Vec<String>, s: String) -> i32 {
        
        let mut count = 0;
        for word in words {
            if word.len() > s.len() {
                continue;
            }
            if s.starts_with(&word) {
                count += 1;
            }
        }
        count
    }
}