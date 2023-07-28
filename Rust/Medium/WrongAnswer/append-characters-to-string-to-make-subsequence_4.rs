impl Solution {
    pub fn append_characters(s: String, t: String) -> i32 {
        
        let mut s = s.chars().rev().collect::<Vec<_>>();
        let mut t = t.chars().rev().collect::<Vec<_>>();
        let mut ans = 0;
        while !t.is_empty() {
            if s.is_empty() {
                ans += t.len() as i32;
                break;
            }
            if s.last() == t.last() {
                s.pop();
                t.pop();
            } else {
                s.pop();
                ans += 1;
            }
        }
        ans
    }
}