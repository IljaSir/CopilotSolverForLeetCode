impl Solution {
    pub fn break_palindrome(palindrome: String) -> String {
        
        let mut s = palindrome.as_bytes().to_vec();
        let n = s.len();
        let mut i = 0;
        while i < n / 2 && s[i] == b'a' {
            i += 1;
        }
        if i < n / 2 {
            s[i] = b'a';
        } else if n > 1 {
            s[n - 1] = b'b';
        } else {
            return "".to_string();
        }
        String::from_utf8(s).unwrap()
    }
}