impl Solution {
    pub fn remove_occurrences(s: String, part: String) -> String {
        
        let mut s = s;
        let part = part.as_bytes();
        let mut i = 0;
        let mut j = 0;
        while i < s.len() {
            if s.as_bytes()[i] == part[j] {
                j += 1;
                if j == part.len() {
                    s.replace_range(i - j + 1..i + 1, "");
                    i = i - j;
                    j = 0;
                }
            } else {
                j = 0;
            }
            i += 1;
        }
        s
    }
}