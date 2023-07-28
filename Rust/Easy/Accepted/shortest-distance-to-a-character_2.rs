impl Solution {
    pub fn shortest_to_char(s: String, c: char) -> Vec<i32> {
        
        let mut ans = vec![0; s.len()];
        let mut last = -1;
        for i in 0..s.len() {
            if s.as_bytes()[i] == c as u8 {
                ans[i] = 0;
                last = i as i32;
            } else if last >= 0 {
                ans[i] = i as i32 - last;
            } else {
                ans[i] = s.len() as i32;
            }
        }
        last = -1;
        for i in (0..s.len()).rev() {
            if s.as_bytes()[i] == c as u8 {
                ans[i] = 0;
                last = i as i32;
            } else if last >= 0 {
                ans[i] = ans[i].min(last - i as i32);
            }
        }
        ans
    }
}