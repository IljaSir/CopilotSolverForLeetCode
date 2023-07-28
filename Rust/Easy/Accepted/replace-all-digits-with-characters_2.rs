impl Solution {
    pub fn replace_digits(s: String) -> String {
        
        let mut r = String::new();
        let mut i = 0;
        while i < s.len() {
            r.push(s.chars().nth(i).unwrap());
            if i < s.len() - 1 {
                r.push((s.chars().nth(i).unwrap() as u8 + s.chars().nth(i+1).unwrap() as u8 - '0' as u8) as char);
            }
            i += 2;
        }
        r
    }
}