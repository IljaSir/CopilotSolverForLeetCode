impl Solution {
    pub fn reverse_prefix(word: String, ch: char) -> String {
        
        let mut s = word.into_bytes();
        let mut i = 0;
        while i < s.len() && s[i] != ch as u8 {
            i += 1;
        }
        if i < s.len() {
            let mut j = 0;
            while j < i {
                s.swap(j, i);
                j += 1;
                i -= 1;
            }
        }
        String::from_utf8(s).unwrap()
    }
}