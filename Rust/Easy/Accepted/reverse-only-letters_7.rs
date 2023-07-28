impl Solution {
    pub fn reverse_only_letters(s: String) -> String {
        
        let mut s = s.into_bytes();
        let mut l = 0;
        let mut r = s.len() - 1;
        while l < r {
            if !s[l].is_ascii_alphabetic() {
                l += 1;
            } else if !s[r].is_ascii_alphabetic() {
                r -= 1;
            } else {
                s.swap(l, r);
                l += 1;
                r -= 1;
            }
        }
        unsafe { String::from_utf8_unchecked(s) }
    }
}