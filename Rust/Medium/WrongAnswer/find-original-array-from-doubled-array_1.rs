impl Solution {
    pub fn find_original_array(changed: Vec<i32>) -> Vec<i32> {
        
        let mut changed = changed;
        changed.sort();
        let mut result = Vec::new();
        let mut i = 0;
        while i < changed.len() {
            if i + 1 < changed.len() && changed[i] == changed[i + 1] {
                result.push(changed[i]);
                i += 2;
            } else {
                return vec![];
            }
        }
        result
    }
}