impl Solution {
    pub fn is_palindrome(s: String) -> bool {
        
        let mut s = s;
        s = s.to_lowercase();
        s = s.chars().filter(|c| c.is_alphanumeric()).collect();
        let mut s_rev = s.clone();
        s_rev = s_rev.chars().rev().collect();
        s == s_rev
    }
}