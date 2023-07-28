impl Solution {
    pub fn find_replace_string(s: String, indices: Vec<i32>, sources: Vec<String>, targets: Vec<String>) -> String {
        
        let mut s = s.into_bytes();
        let mut i = 0;
        while i < indices.len() {
            let index = indices[i] as usize;
            let source = sources[i].as_bytes();
            let target = targets[i].as_bytes();
            if s[index..(index + source.len())] == *source {
                s.splice(index..(index + source.len()), target.iter().cloned());
            }
            i += 1;
        }
        String::from_utf8(s).unwrap()
    }
}