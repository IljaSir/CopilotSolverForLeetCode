impl Solution {
    pub fn first_uniq_char(s: String) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for c in s.chars() {
            *map.entry(c).or_insert(0) += 1;
        }
        for (i, c) in s.chars().enumerate() {
            if let Some(&1) = map.get(&c) {
                return i as i32;
            }
        }
        -1
    }
}