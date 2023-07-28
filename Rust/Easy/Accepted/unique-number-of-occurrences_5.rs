impl Solution {
    pub fn unique_occurrences(arr: Vec<i32>) -> bool {
        
        use std::collections::HashMap;
        let mut map = HashMap::new();
        for num in &arr {
            *map.entry(num).or_insert(0) += 1;
        }
        let mut set = std::collections::HashSet::new();
        for (_, v) in map {
            if !set.insert(v) {
                return false;
            }
        }
        true
    }
}