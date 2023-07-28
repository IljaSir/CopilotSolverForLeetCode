impl Solution {
    pub fn equal_substring(s: String, t: String, max_cost: i32) -> i32 {
        
        let mut cost = 0;
        let mut max = 0;
        let mut i = 0;
        let mut j = 0;
        let mut n = s.len();
        while j < n {
            cost += (s.as_bytes()[j] as i32 - t.as_bytes()[j] as i32).abs();
            while cost > max_cost {
                cost -= (s.as_bytes()[i] as i32 - t.as_bytes()[i] as i32).abs();
                i += 1;
            }
            max = max.max(j - i + 1);
            j += 1;
        }
        max as i32
    }
}