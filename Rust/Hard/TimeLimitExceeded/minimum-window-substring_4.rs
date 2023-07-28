impl Solution {
    pub fn min_window(s: String, t: String) -> String {
        
        let mut res = String::new();
        let mut need = std::collections::HashMap::new();
        let mut window = std::collections::HashMap::new();
        for c in t.chars() {
            *need.entry(c).or_insert(0) += 1;
        }
        let mut left = 0;
        let mut right = 0;
        let mut valid = 0;
        let mut start = 0;
        let mut len = usize::MAX;
        while right < s.len() {
            let c = s.chars().nth(right).unwrap();
            right += 1;
            if need.contains_key(&c) {
                *window.entry(c).or_insert(0) += 1;
                if *need.get(&c).unwrap() == *window.get(&c).unwrap() {
                    valid += 1;
                }
            }
            while valid == need.len() {
                if right - left < len {
                    start = left;
                    len = right - left;
                }
                let d = s.chars().nth(left).unwrap();
                left += 1;
                if need.contains_key(&d) {
                    if *need.get(&d).unwrap() == *window.get(&d).unwrap() {
                        valid -= 1;
                    }
                    *window.get_mut(&d).unwrap() -= 1;
                }
            }
        }
        if len == usize::MAX {
            return res;
        }
        res = s.chars().skip(start).take(len).collect();
        res
    }
}