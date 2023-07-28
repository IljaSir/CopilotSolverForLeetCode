impl Solution {
    pub fn first_uniq_char(s: String) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for c in s.chars() {
            let count = map.entry(c).or_insert(0);
            *count += 1;
        }
        for (i, c) in s.chars().enumerate() {
            if let Some(&count) = map.get(&c) {
                if count == 1 {
                    return i as i32;
                }
            }
        }
        -1
    }
}