impl Solution {
    pub fn min_window(s: String, t: String) -> String {
        
        let (mut left, mut right, mut min_left, mut min_len) = (0, 0, 0, s.len() + 1);
        let (mut count, mut t_map) = (t.len(), vec![0; 128]);
        for c in t.chars() {
            t_map[c as usize] += 1;
        }
        for c in s.chars() {
            if t_map[c as usize] > 0 {
                count -= 1;
            }
            t_map[c as usize] -= 1;
            while count == 0 {
                if right - left + 1 < min_len {
                    min_len = right - left + 1;
                    min_left = left;
                }
                let c = s.chars().nth(left).unwrap();
                t_map[c as usize] += 1;
                if t_map[c as usize] > 0 {
                    count += 1;
                }
                left += 1;
            }
            right += 1;
        }
        if min_len == s.len() + 1 {
            return String::new();
        }
        s[min_left..min_left + min_len].to_string()
    }
}