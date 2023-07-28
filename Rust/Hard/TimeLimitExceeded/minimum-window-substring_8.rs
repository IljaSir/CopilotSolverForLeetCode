impl Solution {
    pub fn min_window(s: String, t: String) -> String {
        
        let (mut l, mut r) = (0, 0);
        let (mut chars, mut ans) = (vec![0; 256], String::new());
        let (mut count, mut min) = (t.len(), usize::MAX);
        for c in t.chars() {
            chars[c as usize] += 1;
        }
        for c in s.chars() {
            r += 1;
            if chars[c as usize] > 0 {
                count -= 1;
            }
            chars[c as usize] -= 1;
            while count == 0 {
                if r - l < min {
                    min = r - l;
                    ans = s[l..r].to_string();
                }
                chars[s.chars().nth(l).unwrap() as usize] += 1;
                if chars[s.chars().nth(l).unwrap() as usize] > 0 {
                    count += 1;
                }
                l += 1;
            }
        }
        ans
    }
}