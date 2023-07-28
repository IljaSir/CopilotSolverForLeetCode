impl Solution {
    pub fn repeated_substring_pattern(s: String) -> bool {
        
        let s = s.into_bytes();
        let mut i = 1;
        while i * 2 <= s.len() {
            if s.len() % i == 0 {
                let mut j = i;
                while j < s.len() && s[j] == s[j % i] {
                    j += 1;
                }
                if j == s.len() {
                    return true;
                }
            }
            i += 1;
        }
        false
    }
}