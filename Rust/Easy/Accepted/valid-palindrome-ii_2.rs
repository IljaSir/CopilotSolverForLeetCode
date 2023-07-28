impl Solution {
    pub fn valid_palindrome(s: String) -> bool {
        
        let s = s.as_bytes();
        let mut i = 0;
        let mut j = s.len() - 1;
        while i < j {
            if s[i] != s[j] {
                return Self::is_palindrome(&s, i + 1, j) || Self::is_palindrome(&s, i, j - 1);
            }
            i += 1;
            j -= 1;
        }
        true
    }

    fn is_palindrome(s: &[u8], i: usize, j: usize) -> bool {
        let mut i = i;
        let mut j = j;
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