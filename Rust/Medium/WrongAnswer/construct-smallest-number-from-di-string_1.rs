impl Solution {
    pub fn smallest_number(pattern: String) -> String {
        
        let mut result = String::new();
        let mut i = 1;
        let mut j = pattern.len() as i32 + 1;
        for c in pattern.chars() {
            if c == 'I' {
                result.push_str(&i.to_string());
                i += 1;
            } else {
                result.push_str(&j.to_string());
                j -= 1;
            }
        }
        result.push_str(&j.to_string());
        result
    }
}