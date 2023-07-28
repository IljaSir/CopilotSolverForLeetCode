impl Solution {
    pub fn unique_occurrences(arr: Vec<i32>) -> bool {
        
        let mut count = std::collections::HashMap::new();
        for v in arr {
            *count.entry(v).or_insert(0) += 1;
        }
        let mut set = std::collections::HashSet::new();
        for (_, v) in count {
            if set.contains(&v) {
                return false;
            }
            set.insert(v);
        }
        true
    }
}