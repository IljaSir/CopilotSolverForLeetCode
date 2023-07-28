impl Solution {
    pub fn unique_occurrences(arr: Vec<i32>) -> bool {
        
        let mut map = std::collections::HashMap::new();
        for n in arr {
            *map.entry(n).or_insert(0) += 1;
        }
        let mut set = std::collections::HashSet::new();
        for (_, v) in map {
            if set.contains(&v) {
                return false;
            }
            set.insert(v);
        }
        true
    }
}