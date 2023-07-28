impl Solution {
    pub fn replace_digits(s: String) -> String {
        
        let mut res = String::new();
        for (i, c) in s.chars().enumerate() {
            if i % 2 == 0 {
                res.push(c);
            } else {
                let c = c as u8 - b'0';
                let last = res.chars().last().unwrap();
                res.push((last as u8 + c) as char);
            }
        }
        res
    }
}