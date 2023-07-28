impl Solution {
    pub fn is_palindrome(s: String) -> bool {
        
        let mut s = s.chars().filter(|c| c.is_alphanumeric()).map(|c| c.to_ascii_lowercase()).collect::<Vec<_>>();
        s.reverse();
        let t = s.clone();
        s.reverse();
        s == t
    }
}