impl Solution {
    pub fn equal_substring(s: String, t: String, max_cost: i32) -> i32 {
        
        let mut cost = 0;
        let mut l = 0;
        let mut r = 0;
        let mut max_len = 0;
        let s = s.into_bytes();
        let t = t.into_bytes();
        while r < s.len() {
            cost += (s[r] as i32 - t[r] as i32).abs();
            while cost > max_cost {
                cost -= (s[l] as i32 - t[l] as i32).abs();
                l += 1;
            }
            max_len = max_len.max(r - l + 1);
            r += 1;
        }
        max_len as i32
    }
}