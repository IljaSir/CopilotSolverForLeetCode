impl Solution {
    pub fn is_palindrome(s: String) -> bool {
        
        let mut chars: Vec<char> = s.chars().filter(|c| c.is_alphanumeric()).collect();
        for i in 0..chars.len() / 2 {
            if chars[i].to_ascii_lowercase() != chars[chars.len() - i - 1].to_ascii_lowercase() {
                return false;
            }
        }
        true
    }
}