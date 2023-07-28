impl Solution {
    pub fn replace_digits(s: String) -> String {
        
        let mut result: Vec<char> = Vec::new();
        let mut chars = s.chars();
        while let Some(c) = chars.next() {
            result.push(c);
            if let Some(d) = chars.next() {
                result.push((c as u8 + d as u8 - '0' as u8) as char);
            }
        }
        result.into_iter().collect()
    }
}