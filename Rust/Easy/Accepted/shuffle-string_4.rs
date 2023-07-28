impl Solution {
    pub fn restore_string(s: String, indices: Vec<i32>) -> String {
        
        let mut vec: Vec<char> = vec![' '; s.len()];
        for (i, c) in s.chars().enumerate() {
            vec[indices[i] as usize] = c;
        }
        vec.iter().collect()
    }
}