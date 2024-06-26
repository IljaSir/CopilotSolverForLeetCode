impl Solution {
    pub fn smallest_number(pattern: String) -> String {
        
        let mut s = String::new();
        let mut i = 1;
        let mut j = pattern.len() as i32 + 1;
        for c in pattern.chars() {
            if c == 'I' {
                s.push_str(&i.to_string());
                i += 1;
            } else {
                s.push_str(&j.to_string());
                j -= 1;
            }
        }
        s.push_str(&j.to_string());
        s
    }
}