impl Solution {
    pub fn can_arrange(arr: Vec<i32>, k: i32) -> bool {
        
        let mut map = std::collections::HashMap::new();
        for a in arr {
            let key = ((a % k) + k) % k;
            *map.entry(key).or_insert(0) += 1;
        }
        for (key, val) in map.iter() {
            if key == &0 || val != map.get(&(k - key)).unwrap_or(&0) {
                return false;
            }
        }
        true
    }
}