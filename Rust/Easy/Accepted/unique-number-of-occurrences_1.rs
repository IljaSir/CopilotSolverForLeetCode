impl Solution {
    pub fn unique_occurrences(arr: Vec<i32>) -> bool {
        
        use std::collections::HashMap;
        let mut map = HashMap::new();
        for i in arr {
            *map.entry(i).or_insert(0) += 1;
        }
        let mut set = std::collections::HashSet::new();
        for (_, v) in map.iter() {
            if set.contains(v) {
                return false;
            }
            set.insert(v);
        }
        true
    }
}