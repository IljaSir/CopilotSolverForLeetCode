impl Solution {
    pub fn is_subsequence(s: String, t: String) -> bool {
        
        if s.is_empty() {
            return true;
        }
        let mut i = 0;
        for ch in t.chars() {
            if ch == s.chars().nth(i).unwrap() {
                i += 1;
                if i == s.len() {
                    return true;
                }
            }
        }
        false
    }
}