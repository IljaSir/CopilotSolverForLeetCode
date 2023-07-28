impl Solution {
    pub fn count_prefixes(words: Vec<String>, s: String) -> i32 {
        
        let mut cnt = 0;
        for w in words {
            if w.len() <= s.len() && &s[..w.len()] == w {
                cnt += 1;
            }
        }
        cnt
    }
}