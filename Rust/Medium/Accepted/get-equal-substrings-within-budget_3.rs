impl Solution {
    pub fn equal_substring(s: String, t: String, max_cost: i32) -> i32 {
        
        let s = s.as_bytes();
        let t = t.as_bytes();
        let mut max_len = 0;
        let mut cost = 0;
        let mut start = 0;
        for end in 0..s.len() {
            cost += (s[end] as i32 - t[end] as i32).abs();
            while cost > max_cost {
                cost -= (s[start] as i32 - t[start] as i32).abs();
                start += 1;
            }
            max_len = max_len.max(end - start + 1);
        }
        max_len as i32
    }
}