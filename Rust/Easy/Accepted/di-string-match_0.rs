impl Solution {
    pub fn di_string_match(s: String) -> Vec<i32> {
        
        let mut result = Vec::new();
        let mut left = 0;
        let mut right = s.len() as i32;
        for c in s.chars() {
            if c == 'I' {
                result.push(left);
                left += 1;
            } else {
                result.push(right);
                right -= 1;
            }
        }
        result.push(left);
        result
    }
}