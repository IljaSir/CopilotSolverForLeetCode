impl Solution {
    pub fn is_palindrome(s: String) -> bool {
        
        let mut s = s;
        s.retain(|c| c.is_alphanumeric());
        s.make_ascii_lowercase();
        s == s.chars().rev().collect::<String>()
    }
}