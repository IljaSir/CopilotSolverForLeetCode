impl Solution {
    pub fn valid_palindrome(s: String) -> bool {
        
        let bytes = s.as_bytes();
        let len = bytes.len();
        let mut l = 0;
        let mut r = len - 1;
        while l < r {
            if bytes[l] != bytes[r] {
                return Self::is_palindrome(&bytes, l + 1, r) || Self::is_palindrome(&bytes, l, r - 1);
            }
            l += 1;
            r -= 1;
        }
        true
    }

    fn is_palindrome(bytes: &[u8], l: usize, r: usize) -> bool {
        let mut l = l;
        let mut r = r;
        while l < r {
            if bytes[l] != bytes[r] {
                return false;
            }
            l += 1;
            r -= 1;
        }
        true
    }
}