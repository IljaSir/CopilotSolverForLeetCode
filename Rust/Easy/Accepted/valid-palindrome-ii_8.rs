impl Solution {
    pub fn valid_palindrome(s: String) -> bool {
        
        let (mut i, mut j) = (0, s.len() - 1);
        let cs = s.as_bytes();
        while i < j {
            if cs[i] != cs[j] {
                return Self::is_palindrome(&cs, i + 1, j) || Self::is_palindrome(&cs, i, j - 1);
            }
            i += 1;
            j -= 1;
        }
        true
    }
    fn is_palindrome(cs: &[u8], i: usize, j: usize) -> bool {
        let (mut i, mut j) = (i, j);
        while i < j {
            if cs[i] != cs[j] {
                return false;
            }
            i += 1;
            j -= 1;
        }
        true
    }
}