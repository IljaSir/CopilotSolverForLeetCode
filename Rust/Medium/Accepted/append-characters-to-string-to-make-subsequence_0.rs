impl Solution {
    pub fn append_characters(s: String, t: String) -> i32 {
        
        let s = s.chars().collect::<Vec<char>>();
        let t = t.chars().collect::<Vec<char>>();
        let mut i = 0;
        let mut j = 0;
        while i < s.len() && j < t.len() {
            if s[i] == t[j] {
                j += 1;
            }
            i += 1;
        }
        (t.len() - j) as i32
    }
}