impl Solution {
    pub fn min_window(s: String, t: String) -> String {
        
        let mut map: Vec<i32> = vec![0; 128];
        let mut count = t.len();
        for c in t.chars() {
            map[c as usize] += 1;
        }
        let (mut l, mut r) = (0, 0);
        let (mut ans_l, mut ans_r) = (0, std::usize::MAX);
        while r < s.len() {
            map[s.as_bytes()[r] as usize] -= 1;
            if map[s.as_bytes()[r] as usize] >= 0 {
                count -= 1;
            }
            while count == 0 {
                if r - l < ans_r - ans_l {
                    ans_l = l;
                    ans_r = r;
                }
                map[s.as_bytes()[l] as usize] += 1;
                if map[s.as_bytes()[l] as usize] > 0 {
                    count += 1;
                }
                l += 1;
            }
            r += 1;
        }
        if ans_r == std::usize::MAX {
            return "".to_string();
        }
        return s[ans_l..=ans_r].to_string();
    }
}