impl Solution {
    pub fn min_window(s: String, t: String) -> String {
        
        let mut map = vec![0; 128];
        for c in t.chars() {
            map[c as usize] += 1;
        }
        let mut left = 0;
        let mut right = 0;
        let mut count = t.len();
        let mut res = String::new();
        while right < s.len() {
            let c = s.chars().nth(right).unwrap();
            if map[c as usize] > 0 {
                count -= 1;
            }
            map[c as usize] -= 1;
            if count == 0 {
                while left < right {
                    let c = s.chars().nth(left).unwrap();
                    if map[c as usize] == 0 {
                        break;
                    }
                    map[c as usize] += 1;
                    left += 1;
                }
                if res.is_empty() || right - left + 1 < res.len() {
                    res = s[left..=right].to_string();
                }
                map[s.chars().nth(left).unwrap() as usize] += 1;
                count += 1;
                left += 1;
            }
            right += 1;
        }
        res
    }
}