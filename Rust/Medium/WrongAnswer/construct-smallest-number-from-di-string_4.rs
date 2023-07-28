impl Solution {
    pub fn smallest_number(pattern: String) -> String {
        
        let mut result = String::new();
        let mut left = 0;
        let mut right = pattern.len() as i32;
        for c in pattern.chars() {
            if c == 'I' {
                result.push_str(&left.to_string());
                left += 1;
            } else {
                result.push_str(&right.to_string());
                right -= 1;
            }
        }
        result.push_str(&right.to_string());
        result
    }
}