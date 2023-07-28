impl Solution {
    pub fn reformat_number(number: String) -> String {
        
        let mut s = String::new();
        for c in number.chars() {
            if c.is_digit(10) {
                s.push(c);
            }
        }
        let mut v = Vec::new();
        let len = s.len();
        let mut i = 0;
        while i < len {
            if len - i == 4 {
                v.push(s[i..i+2].to_string());
                i += 2;
            } else if len - i <= 3 {
                v.push(s[i..].to_string());
                break;
            } else {
                v.push(s[i..i+3].to_string());
                i += 3;
            }
        }
        v.join("-")
    }
}