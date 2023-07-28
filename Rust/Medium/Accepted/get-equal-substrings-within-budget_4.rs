impl Solution {
    pub fn equal_substring(s: String, t: String, max_cost: i32) -> i32 {
        
        let mut max_len = 0;
        let mut cost = 0;
        let mut start = 0;
        let mut end = 0;
        let s: Vec<char> = s.chars().collect();
        let t: Vec<char> = t.chars().collect();
        while end < s.len() {
            cost += (s[end] as i32 - t[end] as i32).abs();
            while cost > max_cost {
                cost -= (s[start] as i32 - t[start] as i32).abs();
                start += 1;
            }
            max_len = max_len.max(end - start + 1);
            end += 1;
        }
        max_len as i32
    }
}