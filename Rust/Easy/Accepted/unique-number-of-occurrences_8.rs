impl Solution {
    pub fn unique_occurrences(arr: Vec<i32>) -> bool {
        
        let mut map = std::collections::HashMap::new();
        for i in arr {
            *map.entry(i).or_insert(0) += 1;
        }
        let mut v = Vec::new();
        for i in map.values() {
            v.push(*i);
        }
        v.sort();
        for i in 1..v.len() {
            if v[i - 1] == v[i] {
                return false;
            }
        }
        true
    }
}