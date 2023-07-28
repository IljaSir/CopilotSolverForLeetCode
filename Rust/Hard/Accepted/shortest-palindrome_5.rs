impl Solution {
    pub fn shortest_palindrome(s: String) -> String {
        
        let mut s = s.as_bytes();
        let mut i = s.len();
        while i > 0 {
            if Self::check_palindrome(&s[..i]) {
                break;
            }
            i -= 1;
        }
        let mut ret = Vec::new();
        for &c in &s[i..] {
            ret.push(c);
        }
        ret.reverse();
        for &c in s {
            ret.push(c);
        }
        String::from_utf8(ret).unwrap()
    }
    fn check_palindrome(s: &[u8]) -> bool {
        let mut i = 0;
        let mut j = s.len() - 1;
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