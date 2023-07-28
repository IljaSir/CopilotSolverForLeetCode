impl Solution {
    pub fn sort_string(s: String) -> String {
        
        let mut s = s.into_bytes();
        s.sort();
        let mut result = Vec::new();
        let mut i = 0;
        while i < s.len() {
            let mut j = i + 1;
            while j < s.len() && s[j] == s[i] {
                j += 1;
            }
            result.push(s[i]);
            i = j;
        }
        let mut i = result.len();
        while i > 0 {
            let mut j = i - 1;
            while j > 0 && result[j] == result[j - 1] {
                j -= 1;
            }
            result.push(result[j]);
            i = j;
        }
        unsafe { String::from_utf8_unchecked(result) }
    }
}