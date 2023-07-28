impl Solution {
    pub fn is_palindrome(s: String) -> bool {
        
        let s = s.to_lowercase().chars().filter(|c| c.is_alphanumeric()).collect::<String>();
        let mut l = 0;
        let mut r = s.len() - 1;
        while l < r {
            if s.chars().nth(l).unwrap() != s.chars().nth(r).unwrap() {
                return false;
            }
            l += 1;
            r -= 1;
        }
        true
    }
}