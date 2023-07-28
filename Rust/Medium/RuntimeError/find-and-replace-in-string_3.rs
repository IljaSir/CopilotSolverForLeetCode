impl Solution {
    pub fn find_replace_string(s: String, indices: Vec<i32>, sources: Vec<String>, targets: Vec<String>) -> String {
        
        let mut result = s;
        let mut indices = indices;
        let mut sources = sources;
        let mut targets = targets;
        let mut i = 0;
        while i < indices.len() {
            let index = indices[i] as usize;
            let source = sources[i].to_string();
            let target = targets[i].to_string();
            if result[index..index+source.len()] == source {
                result = result[..index].to_string() + &target + &result[index+source.len()..];
                for j in i+1..indices.len() {
                    if indices[j] as usize >= index {
                        indices[j] -= source.len() as i32 - target.len() as i32;
                    }
                }
            }
            i += 1;
        }
        result
    }
}