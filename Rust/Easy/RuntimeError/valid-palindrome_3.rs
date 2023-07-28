impl Solution {
    pub fn is_palindrome(s: String) -> bool {
        
        let s = s.to_lowercase();
        let s: String = s.chars().filter(|c| c.is_alphanumeric()).collect();
        let s = s.as_bytes();
        let mut i = 0;
        let mut j = s.len() - 1;
        while i < j {
            if s[i] != s[j] {
                return false;
            }
            i += 1;
            j -= 1;
        }
        true
    }
}