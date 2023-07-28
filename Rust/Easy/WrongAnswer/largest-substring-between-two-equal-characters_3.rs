impl Solution {
    pub fn max_length_between_equal_characters(s: String) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut max = -1;
        for (i, c) in s.char_indices() {
            if map.contains_key(&c) {
                max = std::cmp::max(i as i32 - map[&c], max);
            } else {
                map.insert(c, i as i32);
            }
        }
        max
    }
}