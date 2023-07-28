impl Solution {
    pub fn count_prefixes(words: Vec<String>, s: String) -> i32 {
        
        let mut count = 0;
        for w in words {
            if s.starts_with(&w) {
                count += 1;
            }
        }
        count
    }
}