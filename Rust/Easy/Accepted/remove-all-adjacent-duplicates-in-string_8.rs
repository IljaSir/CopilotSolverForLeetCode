impl Solution {
    pub fn remove_duplicates(s: String) -> String {
        
        let mut s = s.as_bytes().to_vec();
        let mut i = 0;
        for j in 0..s.len() {
            s[i] = s[j];
            if i > 0 && s[i - 1] == s[i] {
                i -= 2;
            }
            i += 1;
        }
        unsafe { String::from_utf8_unchecked(s[..i].to_vec()) }
    }
}