impl Solution {
    pub fn valid_palindrome(s: String) -> bool {
        
        let mut l = 0;
        let mut r = s.len() - 1;
        let mut s = s.as_bytes();

        while l < r {
            if s[l] != s[r] {
                return Self::valid_palindrome_helper(&s[l + 1..r + 1]) || Self::valid_palindrome_helper(&s[l..r]);
            }
            l += 1;
            r -= 1;
        }
        true
    }

    fn valid_palindrome_helper(s: &[u8]) -> bool {
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