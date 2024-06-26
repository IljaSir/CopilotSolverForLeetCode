impl Solution {
    pub fn break_palindrome(palindrome: String) -> String {
        
        if palindrome.len() == 1 {
            return "".to_string();
        }
        let mut palindrome = palindrome.into_bytes();
        for i in 0..palindrome.len() / 2 {
            if palindrome[i] != b'a' {
                palindrome[i] = b'a';
                return String::from_utf8(palindrome).unwrap();
            }
        }
        palindrome[palindrome.len() - 1] = b'b';
        String::from_utf8(palindrome).unwrap()
    }
}