impl Solution {
    pub fn append_characters(s: String, t: String) -> i32 {
        
        let mut t = t.chars().rev().collect::<Vec<char>>();
        let mut s = s.chars().rev().collect::<Vec<char>>();
        let mut i = 0;
        while i < t.len() {
            if t[i] == s[s.len()-1] {
                t.pop();
                s.pop();
            } else {
                s.pop();
            }
            if s.is_empty() {
                break;
            }
        }
        t.len() as i32
    }
}