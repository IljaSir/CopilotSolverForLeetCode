impl Solution {
    pub fn break_palindrome(palindrome: String) -> String {
        
        let mut s = palindrome.as_bytes().to_vec();
        let n = s.len();
        if n == 1 {
            return "".to_string();
        }
        for i in 0..n / 2 {
            if s[i] != b'a' {
                s[i] = b'a';
                return String::from_utf8(s).unwrap();
            }
        }
        s[n - 1] = b'b';
        String::from_utf8(s).unwrap()
    }
}