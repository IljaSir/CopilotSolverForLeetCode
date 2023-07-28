impl Solution {
    pub fn break_palindrome(palindrome: String) -> String {
        
        let mut p = palindrome;
        let mut i = 0;
        let mut j = p.len() - 1;
        while i < j {
            if p.as_bytes()[i] != b'a' {
                p.as_bytes_mut()[i] = b'a';
                return p;
            }
            i += 1;
            j -= 1;
        }
        if p.len() > 1 {
            p.as_bytes_mut()[p.len() - 1] = b'b';
        }
        p
    }
}