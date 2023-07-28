impl Solution {
    pub fn first_uniq_char(s: String) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for c in s.chars() {
            map.entry(c).and_modify(|v| *v += 1).or_insert(1);
        }
        for (i, c) in s.chars().enumerate() {
            if let Some(&v) = map.get(&c) {
                if v == 1 {
                    return i as i32;
                }
            }
        }
        -1
    }
}