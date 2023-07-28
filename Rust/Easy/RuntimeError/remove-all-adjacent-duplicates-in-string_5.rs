impl Solution {
    pub fn remove_duplicates(s: String) -> String {
        
        let mut s = s.into_bytes();
        let mut i = 0;
        for j in 1..s.len() {
            if i >= 0 && s[i] == s[j] {
                i -= 1;
            } else {
                i += 1;
                s[i] = s[j];
            }
        }
        unsafe { String::from_utf8_unchecked(s.into_iter().take(i + 1).collect()) }
    }
}