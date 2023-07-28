impl Solution {
    pub fn di_string_match(s: String) -> Vec<i32> {
        
        let mut r = Vec::with_capacity(s.len() + 1);
        let mut d = s.len() as i32;
        let mut i = 0;
        for c in s.chars() {
            if c == 'I' {
                r.push(i);
                i += 1;
            }
            else {
                r.push(d);
                d -= 1;
            }
        }
        r.push(i);
        r
    }
}