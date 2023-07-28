impl Solution {
    pub fn break_palindrome(palindrome: String) -> String {
        
        let mut palindrome = palindrome.into_bytes();
        let n = palindrome.len();
        let mut changed = false;
        for i in 0..n / 2 {
            if palindrome[i] != b'a' {
                palindrome[i] = b'a';
                changed = true;
                break;
            }
        }
        if !changed && n > 1 {
            palindrome[n - 1] = b'b';
        }
        String::from_utf8(palindrome).unwrap()
    }
}