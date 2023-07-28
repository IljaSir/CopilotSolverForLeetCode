impl Solution {
    pub fn freq_alphabets(s: String) -> String {
        
        let mut chars: Vec<char> = s.chars().collect();
        let mut res = String::new();
        let mut i = 0;
        while i < chars.len() {
            if i + 2 < chars.len() && chars[i + 2] == '#' {
                res.push((chars[i] as u8 - b'0') * 10 + (chars[i + 1] as u8 - b'0') + b'a' - 1);
                i += 3;
            } else {
                res.push(chars[i] as u8 - b'1' + b'a');
                i += 1;
            }
        }
        res
    }
}