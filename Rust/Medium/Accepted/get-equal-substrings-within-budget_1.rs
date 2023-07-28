impl Solution {
    pub fn equal_substring(s: String, t: String, max_cost: i32) -> i32 {
        
        let s = s.as_bytes();
        let t = t.as_bytes();
        let n = s.len();
        let mut cost = 0;
        let mut ans = 0;
        let mut l = 0;
        for r in 0..n {
            cost += (s[r] as i32 - t[r] as i32).abs();
            while cost > max_cost {
                cost -= (s[l] as i32 - t[l] as i32).abs();
                l += 1;
            }
            ans = ans.max(r - l + 1);
        }
        ans as i32
    }
}