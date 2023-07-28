impl Solution {
    pub fn find_replace_string(s: String, indices: Vec<i32>, sources: Vec<String>, targets: Vec<String>) -> String {
        
        let mut s = s.clone();
        let mut indices = indices.clone();
        let mut sources = sources.clone();
        let mut targets = targets.clone();
        let mut i = 0;
        while i < indices.len() {
            let mut j = i;
            while j < indices.len() && indices[i] == indices[j] {
                j += 1;
            }
            for k in i..j {
                let index = indices[k] as usize;
                let source = sources[k].clone();
                let target = targets[k].clone();
                if s[index..index + source.len()] == source {
                    s = s[..index].to_string() + &target + &s[index + source.len()..];
                }
            }
            i = j;
        }
        s
    }
}