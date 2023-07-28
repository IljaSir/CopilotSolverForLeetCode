impl Solution {
    pub fn restore_string(s: String, indices: Vec<i32>) -> String {
        
        let mut result = s.clone();
        for i in 0..s.len() {
            result.replace_range(indices[i] as usize..indices[i] as usize + 1, &s[i..i+1]);
        }
        result
    }
}