impl Solution {
    pub fn shortest_palindrome(s: String) -> String {
        
        let s = s.as_bytes();
        let n = s.len();
        let mut i = 0;
        for j in (0..n).rev() {
            if s[i] == s[j] {
                i += 1;
            }
        }
        if i == n {
            return String::from_utf8(s.to_vec()).unwrap();
        }
        let rem = &s[i..];
        let mut rem_rev = rem.to_vec();
        rem_rev.reverse();
        let mut left = rem_rev;
        left.extend_from_slice(s);
        let mut right = s.to_vec();
        right.extend_from_slice(&rem_rev);
        let mut left = Self::shortest_palindrome(String::from_utf8(left).unwrap());
        let mut right = Self::shortest_palindrome(String::from_utf8(right).unwrap());
        if left.len() < right.len() {
            left
        } else {
            right
        }
    }
}