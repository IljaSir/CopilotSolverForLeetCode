impl Solution {
    pub fn is_palindrome(s: String) -> bool {
        
        let s = s.to_lowercase();
        let mut s = s.chars().filter(|c| c.is_alphanumeric()).collect::<String>();
        s = s.chars().rev().collect::<String>();
        let mut s1 = s.clone();
        s1 = s1.chars().rev().collect::<String>();
        s == s1
    }
}