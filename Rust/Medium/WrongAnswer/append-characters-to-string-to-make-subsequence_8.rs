impl Solution {
    pub fn append_characters(s: String, t: String) -> i32 {
        
        let mut s = s.chars();
        let mut t = t.chars();
        let mut t_char = t.next();
        let mut count = 0;
        for c in s {
            if let Some(tc) = t_char {
                if c == tc {
                    t_char = t.next();
                }
            } else {
                count += 1;
            }
        }
        if t_char.is_some() {
            return -1;
        }
        count
    }
}