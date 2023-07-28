impl Solution {
    pub fn min_window(s: String, t: String) -> String {
        
        let mut t_map = std::collections::HashMap::new();
        for c in t.chars() {
            *t_map.entry(c).or_insert(0) += 1;
        }
        let mut s_map = std::collections::HashMap::new();
        let mut count = 0;
        let mut left = 0;
        let mut right = 0;
        let mut min_len = std::usize::MAX;
        let mut min_left = 0;
        let mut min_right = 0;
        for c in s.chars() {
            *s_map.entry(c).or_insert(0) += 1;
            if t_map.contains_key(&c) {
                if s_map[&c] <= t_map[&c] {
                    count += 1;
                }
            }
            while count == t.len() {
                if right - left + 1 < min_len {
                    min_len = right - left + 1;
                    min_left = left;
                    min_right = right;
                }
                if t_map.contains_key(&s.chars().nth(left).unwrap()) {
                    s_map.entry(s.chars().nth(left).unwrap()).and_modify(|e| *e -= 1);
                    if s_map[&s.chars().nth(left).unwrap()] < t_map[&s.chars().nth(left).unwrap()] {
                        count -= 1;
                    }
                }
                left += 1;
            }
            right += 1;
        }
        if min_len == std::usize::MAX {
            "".to_string()
        } else {
            s[min_left..=min_right].to_string()
        }
    }
}