impl Solution {
    pub fn restore_string(s: String, indices: Vec<i32>) -> String {
        
        let mut result = String::new();
        let mut result_chars = vec![' '; indices.len()];
        for (i, c) in s.chars().enumerate() {
            result_chars[indices[i] as usize] = c;
        }
        for c in result_chars {
            result.push(c);
        }
        result
    }
}