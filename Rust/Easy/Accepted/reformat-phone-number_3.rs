impl Solution {
    pub fn reformat_number(number: String) -> String {
        
        let mut s = String::new();
        for c in number.chars() {
            if c.is_digit(10) {
                s.push(c);
            }
        }
        let mut r = String::new();
        let mut i = 0;
        while i < s.len() {
            if s.len() - i == 4 {
                r.push_str(&s[i..i+2]);
                r.push('-');
                i += 2;
            } else if s.len() - i <= 3 {
                r.push_str(&s[i..]);
                i = s.len();
            } else {
                r.push_str(&s[i..i+3]);
                r.push('-');
                i += 3;
            }
        }
        r
    }
}