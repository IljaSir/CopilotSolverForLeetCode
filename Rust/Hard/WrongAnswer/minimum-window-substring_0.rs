impl Solution {
    pub fn min_window(s: String, t: String) -> String {
        
        use std::collections::HashMap;
        let mut map: HashMap<char, usize> = HashMap::new();
        for c in t.chars() {
            *map.entry(c).or_insert(0) += 1;
        }
        let mut count = map.len();
        let mut left = 0;
        let mut right = 0;
        let mut ans = (0, std::usize::MAX);
        while right < s.len() {
            if let Some(v) = map.get_mut(&s.chars().nth(right).unwrap()) {
                *v -= 1;
                if *v == 0 {
                    count -= 1;
                }
            }
            right += 1;
            while count == 0 {
                if right - left < ans.1 - ans.0 {
                    ans = (left, right);
                }
                if let Some(v) = map.get_mut(&s.chars().nth(left).unwrap()) {
                    *v += 1;
                    if *v > 0 {
                        count += 1;
                    }
                }
                left += 1;
            }
        }
        if ans.1 > s.len() {
            return "".to_string();
        }
        return s[ans.0..ans.1].to_string();
    }
}