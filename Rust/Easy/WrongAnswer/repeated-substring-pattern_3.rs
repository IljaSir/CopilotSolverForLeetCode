impl Solution {
    pub fn repeated_substring_pattern(s: String) -> bool {
        
        let s = s.as_bytes();
        let mut k = 0;
        for i in 1..s.len() {
            if s[k] == s[i] {
                k += 1;
            } else {
                k = 0;
            }
        }
        if k == 0 {
            return false;
        }
        let mut i = 0;
        while i < s.len() - k {
            if s[i] != s[i + k] {
                return false;
            }
            i += 1;
        }
        true
    }
}