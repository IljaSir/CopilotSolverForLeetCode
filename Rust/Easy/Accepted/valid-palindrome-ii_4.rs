impl Solution {
    pub fn valid_palindrome(s: String) -> bool {
        
        let mut l = 0;
        let mut r = s.len() - 1;
        let s = s.as_bytes();
        while l < r {
            if s[l] != s[r] {
                return Solution::is_palindrome(&s[l + 1..r + 1]) || Solution::is_palindrome(&s[l..r]);
            }
            l += 1;
            r -= 1;
        }
        true
    }
    fn is_palindrome(s: &[u8]) -> bool {
        let mut l = 0;
        let mut r = s.len() - 1;
        while l < r {
            if s[l] != s[r] {
                return false;
            }
            l += 1;
            r -= 1;
        }
        true
    }
}