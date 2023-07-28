impl Solution {
    pub fn restore_string(s: String, indices: Vec<i32>) -> String {
        
        let mut v: Vec<char> = s.chars().collect();
        let mut s = String::new();
        for i in 0..indices.len() {
            v[indices[i] as usize] = s.chars().nth(i).unwrap();
        }
        for i in 0..v.len() {
            s.push(v[i]);
        }
        s
    }
}