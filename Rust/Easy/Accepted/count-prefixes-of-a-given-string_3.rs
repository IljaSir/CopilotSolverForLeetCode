impl Solution {
    pub fn count_prefixes(words: Vec<String>, s: String) -> i32 {
        
        let mut count = 0;
        for i in words {
            if s.starts_with(&i) {
                count += 1;
            }
        }
        count
    }
}