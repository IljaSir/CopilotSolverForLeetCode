impl Solution {
    pub fn replace_digits(s: String) -> String {
        
        let mut res = String::new();
        let s = s.as_bytes();
        for i in 0..s.len() {
            if s[i].is_ascii_digit() {
                res.push((s[i-1] + s[i] - 48) as char);
            } else {
                res.push(s[i] as char);
            }
        }
        res
    }
}