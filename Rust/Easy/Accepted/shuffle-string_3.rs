impl Solution {
    pub fn restore_string(s: String, indices: Vec<i32>) -> String {
        
        let mut chars = s.chars().collect::<Vec<char>>();
        let mut result = chars.clone();
        for i in 0..indices.len() {
            result[indices[i] as usize] = chars[i];
        }
        result.iter().collect()
    }
}