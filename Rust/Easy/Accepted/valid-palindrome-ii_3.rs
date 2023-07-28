impl Solution {
    pub fn valid_palindrome(s: String) -> bool {
        
        let s = s.as_bytes();
        let mut l = 0;
        let mut r = s.len() - 1;
        while l < r {
            if s[l] != s[r] {
                return Solution::is_palindrome(&s, l + 1, r) || Solution::is_palindrome(&s, l, r - 1);
            }
            l += 1;
            r -= 1;
        }
        true
    }
    fn is_palindrome(s: &[u8], l: usize, r: usize) -> bool {
        let mut l = l;
        let mut r = r;
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