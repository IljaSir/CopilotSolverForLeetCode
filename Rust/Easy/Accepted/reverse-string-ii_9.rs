impl Solution {
    pub fn reverse_str(s: String, k: i32) -> String {
        
        let mut ans = String::new();
        let mut s = s;
        let mut k = k;
        while s.len() > 0 {
            let mut part = String::new();
            if s.len() >= k as usize {
                part = s.drain(..k as usize).collect();
            } else {
                part = s.drain(..).collect();
            }
            ans.push_str(&part.chars().rev().collect::<String>());
            if s.len() >= k as usize {
                part = s.drain(..k as usize).collect();
            } else {
                part = s.drain(..).collect();
            }
            ans.push_str(&part);
        }
        ans
    }
}