impl Solution {
    pub fn repeated_substring_pattern(s: String) -> bool {
        
        let s = s.as_bytes();
        let len = s.len();
        for i in 1..len {
            if len % i == 0 {
                let mut j = i;
                while j < len && s[j] == s[j % i] {
                    j += 1;
                }
                if j == len {
                    return true;
                }
            }
        }
        false
    }
}