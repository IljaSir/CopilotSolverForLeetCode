impl Solution {
    pub fn max_length_between_equal_characters(s: String) -> i32 {
        
        let mut res = -1;
        let mut h = std::collections::HashMap::new();
        for (i, c) in s.chars().enumerate() {
            if let Some(&j) = h.get(&c) {
                res = res.max(i as i32 - j as i32 - 1);
            } else {
                h.insert(c, i);
            }
        }
        res
    }
}