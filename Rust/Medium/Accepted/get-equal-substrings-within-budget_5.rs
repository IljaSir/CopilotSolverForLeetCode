impl Solution {
    pub fn equal_substring(s: String, t: String, max_cost: i32) -> i32 {
        
        let s = s.as_bytes();
        let t = t.as_bytes();
        let mut sum = 0;
        let mut l = 0;
        let mut r = 0;
        let mut max_len = 0;
        while r < s.len() {
            sum += (s[r] as i32 - t[r] as i32).abs();
            while sum > max_cost {
                sum -= (s[l] as i32 - t[l] as i32).abs();
                l += 1;
            }
            max_len = max_len.max(r - l + 1);
            r += 1;
        }
        max_len as i32
    }
}